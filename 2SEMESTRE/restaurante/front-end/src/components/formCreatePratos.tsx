"use client";
import { Button } from "./ui/button";
import { DialogFooter } from "./ui/dialog";
import { Input } from "./ui/input";
import { Label } from "./ui/label";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { api } from "@/services/api";
import { toast } from "sonner";
import { queryClient } from "@/services/QueryClient";

const pratoCreateSchema = z.object({
  nome: z.string().min(3, { message: "Nome muito curto" }).toLowerCase(),
  preco: z.coerce.number().min(1, { message: "Preço inválido" }),
});

type PratoCreateSchema = z.infer<typeof pratoCreateSchema>;

export const FormCreatePratos = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
  } = useForm<PratoCreateSchema>({
    resolver: zodResolver(pratoCreateSchema),
    mode: "all",
    criteriaMode: "all",
    defaultValues: {
      nome: "",
      preco: 0,
    },
  });

  const handleAddPrato = async (data: PratoCreateSchema) => {
    await api.post("/prato", data);
    queryClient.invalidateQueries({ queryKey: ["pratos"] });
    toast.success("Prato adicionado");
    setValue("nome", "");
    setValue("preco", 0);
  };

  return (
    <form
      onSubmit={handleSubmit(handleAddPrato)}
      className="flex flex-col gap-2"
    >
      <Label>Nome</Label>
      <Input {...register("nome")} placeholder="Macarrão" />
      <p className="text-xs text-primary">{errors.nome?.message}</p>
      <Label>Preço</Label>
      <Input {...register("preco")} placeholder="R$ 12.00" />
      <p className="text-xs text-primary">{errors.preco?.message}</p>
      <DialogFooter>
        <Button type="submit">Adicionar</Button>
      </DialogFooter>
    </form>
  );
};
