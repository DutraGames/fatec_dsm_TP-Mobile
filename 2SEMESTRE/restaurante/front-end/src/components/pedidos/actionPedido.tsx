"use client";
import { Button } from "../ui/button";
import { z } from "zod";
import { useForm, useFieldArray } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { api } from "@/services/api";
import { toast } from "sonner";
import { queryClient } from "@/services/QueryClient";
import { useQuery } from "@tanstack/react-query";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
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

const pedidoCreateSchema = z.object({
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
  id: number;
  pratos: PratoProps[];
  valorTotal: number;
}

type PedidoCreateSchema = z.infer<typeof pedidoCreateSchema>;

export const ActionPedido = (props: PedidoProps) => {
  const form = useForm<PedidoCreateSchema>({
    resolver: zodResolver(pedidoCreateSchema),
  });

  const getPedidos = async () => {
    const response: { data: PedidoProps[] } = await api.get("/pedidos");
    return response.data;
  };

  const { data } = useQuery({
    queryKey: ["pedidos"],
    queryFn: getPedidos,
  });

  const handleDeletePedido = async (id: number) => {
    await api.delete(`/pedidos/${id}`);
    queryClient.invalidateQueries({ queryKey: ["pedidos"] });

  return (
    <Dialog>
      <Button
        variant="destructive"
        onClick={() => handleDeletePedido(props.id)}
      >
        Deletar
      </Button>
      <DialogTrigger className="rounded-md p-2 font-bold bg-primary-foreground text-zinc-950 transition-all">
        Editar
      </DialogTrigger>

      <DialogContent>
        <DialogHeader>
          <DialogTitle>Editar Prato</DialogTitle>
          <DialogDescription>Edite os dados do prato</DialogDescription>
          <form
            onSubmit={handleSubmit(handleUpdatePrato)}
            className="flex flex-col gap-2"
          >
            <Label>Nome</Label>
            <Input {...register("nome")} placeholder="Macarrão" />
            <p className="text-xs text-primary">{errors.nome?.message}</p>
            <Label>Preço</Label>
            <Input
              {...registerWithMask("preco", ["999.99"], {
                required: true,
              })}
              placeholder="R$ 12.00"
            />
            <p className="text-xs text-primary">{errors.preco?.message}</p>
            <DialogFooter>
              <Button type="submit">Salvar</Button>
            </DialogFooter>
          </form>
        </DialogHeader>
      </DialogContent>
    </Dialog>
  );
};
