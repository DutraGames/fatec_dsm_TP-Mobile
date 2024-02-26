import Image from "next/image";

import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { FormCreatePedidos } from "@/components/pedidos/formCreatePedido";

export default function Home() {
  return (
    <div className="flex flex-col">
      <Dialog>
        <header className="flex items-center justify-between p-4 border-b-2 border-secondary/10">
          <h1 className="text-2xl font-bold">Bom Prato</h1>

          <DialogTrigger className="rounded-md bg-primary p-2 font-bold hover:bg-primary/80 transition-all">
            Adicionar Pedido
          </DialogTrigger>
        </header>

        <main className="mt-10 mx-40"></main>

        <DialogContent className="text-zinc-950">
          <DialogHeader>
            <DialogTitle>Adicionar Pedido</DialogTitle>
            <DialogDescription>Preencha os dados do Pedido</DialogDescription>
          </DialogHeader>
          <FormCreatePedidos />
        </DialogContent>
      </Dialog>
    </div>
  );
}
