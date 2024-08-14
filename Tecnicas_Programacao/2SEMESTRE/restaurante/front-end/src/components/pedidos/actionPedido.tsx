"use client";
import { Button } from "../ui/button";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { api } from "@/services/api";
import { toast } from "sonner";
import { queryClient } from "@/services/QueryClient";
import { useQuery } from "@tanstack/react-query";
import {
  DialogFooter,
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTrigger,
  DialogDescription,
  DialogTitle,
} from "../ui/dialog";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";

const pedidoUpdateSchema = z.object({
  id: z.number(),
  reserva: z.enum(["sim", "nao"], {
    required_error: "Escolha se deseja realizar uma reserva",
  }),
  pratos: z.string({
    required_error: "Selecione ao menos um prato",
  }),
});

interface PratoProps {
  id: number;
  nome: string;
  preco: number;
}

interface PedidoProps {
  pedido: {
    id: number;
    pratos: PratoProps[];
    valorTotal: number;
  };
}

type PedidoUpdateSchema = z.infer<typeof pedidoUpdateSchema>;

export const ActionPedido = ({ pedido }: PedidoProps) => {
  const form = useForm<PedidoUpdateSchema>({
    resolver: zodResolver(pedidoUpdateSchema),
  });

  const getPratos = async () => {
    const response: { data: PratoProps[] } = await api.get("/prato");
    return response.data;
  };

  const getPedidos = async () => {
    const response: { data: PedidoProps[] } = await api.get("/pedidos");
    return response.data;
  };

  const { data: pratos } = useQuery({
    queryKey: ["pratos"],
    queryFn: getPratos,
  });

  const handleDeletePedido = async (id: number) => {
    await api.delete(`/pedidos/${id}`);
    queryClient.invalidateQueries({ queryKey: ["pedidos"] });
    toast.success("Pedido deletado");
  };

  const handleUpdatePedido = async (data: PedidoUpdateSchema) => {
    await api.put(`/pedidos/${data.id}`, data.pratos);
    queryClient.invalidateQueries({ queryKey: ["pedidos"] });
    toast.success("Pedido Atualizado");
  };

  return (
    <Dialog>
      <Button
        type="button"
        variant="destructive"
        onClick={() => handleDeletePedido(pedido.id)}
      >
        Deletar
      </Button>
      <DialogTrigger className="rounded-md p-2 font-bold bg-primary-foreground text-zinc-950 transition-all">
        Editar
      </DialogTrigger>

      <DialogContent className="text-zinc-950">
        <DialogHeader>
          <DialogTitle>Editar Pedido</DialogTitle>
          <DialogDescription>Edite os dados do pedido</DialogDescription>
        </DialogHeader>
        <Form {...form}>
          <form
            className="space-y-3"
            onSubmit={form.handleSubmit(handleUpdatePedido)}
          >
            <FormField
              control={form.control}
              name="pratos"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Selecione os pratos</FormLabel>
                  <Select
                    onValueChange={field.onChange}
                    defaultValue={field.value}
                  >
                    <FormControl>
                      <SelectTrigger>
                        <SelectValue placeholder="Selecione os pratos do seu pedido" />
                      </SelectTrigger>
                    </FormControl>
                    <SelectContent>
                      {pratos?.map((prato: PratoProps) => (
                        <SelectItem
                          key={prato.id}
                          value={JSON.stringify([
                            {
                              id: prato.id,
                              nome: prato.nome,
                              preco: prato.preco,
                            },
                          ])}
                        >
                          {prato.nome} - R$ {prato.preco.toFixed(2)}
                        </SelectItem>
                      ))}
                    </SelectContent>
                  </Select>
                  <FormMessage />
                </FormItem>
              )}
            />

            <DialogFooter>
              <Button type="submit">Salvar</Button>
            </DialogFooter>
          </form>
        </Form>
      </DialogContent>
    </Dialog>
  );
};
