"use client";
import { Button } from "../ui/button";
import { z } from "zod";
import { useForm, useFieldArray, Controller } from "react-hook-form";
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
import { Label } from "@radix-ui/react-label";

const pratoSchema = z.object({
  id: z.number(),
  nome: z.string(),
  preco: z.number(),
});

const pedidoCreateSchema = z.object({
  tipo: z.enum(["reserva", "entrega"], {
    required_error: "Escolha se deseja realizar uma reserva",
  }),
  pratos: z.array(pratoSchema).min(1, {
    message: "Selecione pelo menos um prato",
  }),
});

type PratoProps = z.infer<typeof pratoSchema>;

type PedidoCreateSchema = z.infer<typeof pedidoCreateSchema>;

export const FormCreatePedidos = () => {
  const { handleSubmit, control, register } = useForm<PedidoCreateSchema>({
    resolver: zodResolver(pedidoCreateSchema),
    mode: "all",
  });

  const { append, fields, remove } = useFieldArray({
    control,
    name: "pratos",
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
    if (data.tipo === "reserva") {
      const mesaData = {
        numero: Math.floor(Math.random() * 5000),
      };

      await api.post("/mesas", mesaData);
      queryClient.invalidateQueries({ queryKey: ["mesas"] });
    }

    await api.post("/pedidos", data.pratos);
    queryClient.invalidateQueries({ queryKey: ["pedidos"] });
    toast.success("Pedido adicionado");

    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit(handleAddPedido)} className="space-y-3">
      <Label>Tipo de Pedido</Label>
      <Controller
        control={control}
        name="tipo"
        defaultValue="reserva"
        render={({ field: { onChange, value } }) => {
          return (
            <RadioGroup
              className="flex items-center"
              onValueChange={onChange}
              value={value}
            >
              <RadioGroupItem value="reserva" id="reserva" />
              <Label htmlFor="reserva">Reserva de mesa</Label>
              <RadioGroupItem value="entrega" id="entrega" />
              <Label htmlFor="entrega">Entrega</Label>
            </RadioGroup>
          );
        }}
      />

      <Controller
        control={control}
        name="pratos"
        render={({ field: { onChange, value } }) => {
          return (
            <div className="flex flex-col gap-2">
              <Label>Selecione os pratos</Label>
              {fields.map((field, index) => {
                return (
                  <div key={field.id} className="flex items-center gap-2">
                    <Select
                      value={JSON.stringify(value[index])}
                      onValueChange={(selectedOption) => {
                        const updatedValue = [...value];
                        updatedValue[index] = JSON.parse(selectedOption);
                        onChange(updatedValue);
                      }}
                    >
                      <SelectTrigger className="w-[180px]">
                        <SelectValue placeholder="Selecione um prato" />
                      </SelectTrigger>
                      <SelectContent onChange={onChange}>
                        {data?.map((prato: PratoProps) => (
                          <SelectItem
                            key={prato.id}
                            value={JSON.stringify(prato)}
                          >
                            {prato.nome} - R$ {prato.preco.toFixed(2)}
                          </SelectItem>
                        ))}
                      </SelectContent>
                    </Select>

                    <Button
                      type="button"
                      onClick={() => remove(index)}
                      variant="destructive"
                    >
                      Remover
                    </Button>
                  </div>
                );
              })}

              <Button
                type="button"
                onClick={() => append({ id: 0, nome: "", preco: 0 })}
              >
                Adicionar
              </Button>
            </div>
          );
        }}
      />

      <DialogFooter>
        <Button type="submit">Criar Pedido</Button>
      </DialogFooter>
    </form>
  );
};
