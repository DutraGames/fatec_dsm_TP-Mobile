"use client";
import { Button } from "@/components/ui/button";
import { api } from "@/services/api";
import {
  DialogDescription,
  DialogHeader,
  Dialog,
  DialogContent,
  DialogTitle,
  DialogTrigger,
  DialogFooter,
} from "./ui/dialog";

import { Input } from "./ui/input";
import { Label } from "./ui/label";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

import { toast } from "sonner";

const pratoEditSchema = z.object({
  nome: z.string().min(3, { message: "Nome muito curto" }).toLowerCase(),
  preco: z.coerce.number().min(1, { message: "Preço inválido" }),
});

type PratoEditSchema = z.infer<typeof pratoEditSchema>;

interface PratoProps {
  prato: {
    id: number;
    nome: string;
    preco: number;
  };
  handleRefresh: () => void;
}

export const ActionPrato = ({ prato, handleRefresh }: PratoProps) => {
  const deletePrato = (id: number) => {
    api.delete(`/prato/${id}`);
    toast.success("Prato deletado");
    handleRefresh();
  };

  const handleUpdatePrato = (data: PratoEditSchema) => {
    api.put(`/prato/${prato.id}`, data);
    toast.success("Prato Editado");
  };

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<PratoEditSchema>({
    resolver: zodResolver(pratoEditSchema),
    defaultValues: {
      nome: prato.nome,
      preco: prato.preco,
    },
  });

  return (
    <Dialog>
      <Button variant="destructive" onClick={() => deletePrato(prato.id)}>
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
            <Input {...register("preco")} placeholder="R$ 12.00" />
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
