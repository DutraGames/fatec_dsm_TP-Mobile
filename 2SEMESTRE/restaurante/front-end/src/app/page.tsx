import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";

import {
  Table,
  TableBody,
  TableCaption,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { FormCreatePedidos } from "@/components/pedidos/formCreatePedido";
import { TablePedidos } from "@/components/pedidos/tablePedidos";

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

        <main className="mt-10 mx-40">
          <Table className="w-full">
            <TableCaption>Seus Pratos Cadastrados</TableCaption>
            <TableHeader>
              <TableRow>
                <TableHead className="w-[100px] text-center">
                  número do pedido
                </TableHead>
                <TableHead>pedido</TableHead>
                <TableHead className="w-[100px]">preço total</TableHead>
                <TableHead className="w-[100px]">Ações</TableHead>
              </TableRow>
            </TableHeader>
            <TablePedidos />
          </Table>
        </main>

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
