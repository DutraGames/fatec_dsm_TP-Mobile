"use client";
import { TableBody, TableCell, TableRow } from "./ui/table";
import { ActionPrato } from "./actionPrato";
import { api } from "@/services/api";
import { useQuery } from "@tanstack/react-query";

interface PratoProps {
  id: number;
  nome: string;
  preco: number;
}

export const TablePratos = () => {
  const getPratos = async () => {
    const response: { data: PratoProps[] } = await api.get("/prato");
    return response.data;
  };

  const { data } = useQuery({
    queryKey: ["pratos"],
    queryFn: getPratos,
  });

  return (
    <TableBody>
      {data?.map((prato: PratoProps) => (
        <TableRow key={prato.id}>
          <TableCell>{prato.id}</TableCell>
          <TableCell>{prato.nome}</TableCell>
          <TableCell>R$ {prato.preco.toFixed(2)}</TableCell>
          <TableCell className="flex gap-2">
            <ActionPrato prato={prato} />
          </TableCell>
        </TableRow>
      ))}
    </TableBody>
  );
};
