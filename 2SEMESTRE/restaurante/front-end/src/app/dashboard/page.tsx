import {
  Table,
  TableBody,
  TableCaption,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { FormCreatePratos } from "@/components/pratos/formCreatePratos";
import { TablePratos } from "@/components/pratos/tablePratos";

export default function Dashboard() {
  return (
    <div className="flex flex-col  h-screen bg-secondary-foreground text-white">
      <Dialog>
        <header className="flex items-center justify-between p-4 bg-secondary-foreground border-b-2 border-secondary/10">
          <h1 className="text-2xl font-bold">Bom Prato</h1>

          <DialogTrigger className="rounded-md bg-primary p-2 font-bold hover:bg-primary/80 transition-all">
            Adicionar Prato
          </DialogTrigger>
        </header>

        <main className="mt-10 mx-40">
          <Table className="w-full">
            <TableCaption>Seus Pratos Cadastrados</TableCaption>
            <TableHeader>
              <TableRow>
                <TableHead className="w-[100px]">id</TableHead>
                <TableHead>Nome</TableHead>
                <TableHead className="w-[100px]">preço</TableHead>
                <TableHead className="w-[100px]">Ações</TableHead>
              </TableRow>
            </TableHeader>

            <TablePratos />
          </Table>

          <DialogContent>
            <DialogHeader>
              <DialogTitle>Adicionar Prato</DialogTitle>
              <DialogDescription>Preencha os dados do prato</DialogDescription>
            </DialogHeader>
            <FormCreatePratos />
          </DialogContent>
        </main>
      </Dialog>
    </div>
  );
}
