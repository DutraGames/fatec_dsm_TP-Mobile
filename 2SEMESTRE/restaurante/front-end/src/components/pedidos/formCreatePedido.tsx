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
import { DialogFooter } from "../ui/dialog";
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

type PedidoCreateSchema = z.infer<typeof pedidoCreateSchema>;

export const FormCreatePedidos = () => {
  const form = useForm<PedidoCreateSchema>({
    resolver: zodResolver(pedidoCreateSchema),
  });

  const getPratos = async () => {
    const response: { data: PratoProps[] } = await api.get("/prato");
    return response.data;
  };

  const { data } = useQuery({
    queryKey: ["pratos"],
    queryFn: getPratos,
  });

  const handleAddPedido = async (data: PedidoCreateSchema) => {
    if (data.reserva === "sim") {
      const mesaData = {
        numero: Math.floor(Math.random() * 5000),
      };

      await api.post("/mesas", mesaData);
      queryClient.invalidateQueries({ queryKey: ["mesas"] });
    }

    await api.post("/pedidos", JSON.parse(data.pratos));
    queryClient.invalidateQueries({ queryKey: ["pedidos"] });
    toast.success("Pedido adicionado");
  };

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(handleAddPedido)} className="space-y-3">
        <FormField
          control={form.control}
          name="reserva"
          render={({ field }) => (
            <FormItem className="space-y-3">
              <FormLabel>Deseja realizar uma reserva</FormLabel>
              <FormControl>
                <RadioGroup
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                  className="flex"
                >
                  <FormItem className="flex items-center space-x-3 space-y-0">
                    <FormControl>
                      <RadioGroupItem value="nao" />
                    </FormControl>
                    <FormLabel className="font-normal">Não</FormLabel>
                  </FormItem>
                  <FormItem className="flex items-center space-x-3 space-y-0">
                    <FormControl>
                      <RadioGroupItem value="sim" />
                    </FormControl>
                    <FormLabel className="font-normal">Sim</FormLabel>
                  </FormItem>
                </RadioGroup>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="pratos"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Selecione os pratos</FormLabel>
              <Select onValueChange={field.onChange} defaultValue={field.value}>
                <FormControl>
                  <SelectTrigger>
                    <SelectValue placeholder="Selecione os pratos do seu pedido" />
                  </SelectTrigger>
                </FormControl>
                <SelectContent>
                  {data?.map((prato: PratoProps) => (
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
          <Button type="submit">Adicionar</Button>
        </DialogFooter>
      </form>
    </Form>
  );
};
