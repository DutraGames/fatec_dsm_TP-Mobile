"use client";
import { TableBody, TableCell, TableRow } from "./ui/table";
import { ActionPrato } from "./actionPrato";
import { api } from "@/services/api";
import { useEffect, useState } from "react";

interface PratoProps {
  id: number;
  nome: string;
  preco: number;
}

export const TablePratos = ({
  handleRefresh,
  refresh,
}: {
  handleRefresh: () => void;
  refresh: boolean;
}) => {
  useEffect(() => {
    const getPratos = async () => {
      const response: { data: PratoProps[] } = await api.get("/prato");
      return response.data;
    };

    getPratos().then((data) => setPratos(data));
  }, [refresh, handleRefresh]);

  const [pratos, setPratos] = useState<PratoProps[]>([]);

  return (
    <TableBody>
      {pratos.map((prato: PratoProps) => (
        <TableRow key={prato.id}>
          <TableCell>{prato.id}</TableCell>
          <TableCell>{prato.nome}</TableCell>
          <TableCell>R$ {prato.preco.toFixed(2)}</TableCell>
          <TableCell className="flex gap-2">
            <ActionPrato prato={prato} handleRefresh={handleRefresh} />
          </TableCell>
        </TableRow>
      ))}
    </TableBody>
  );
};
