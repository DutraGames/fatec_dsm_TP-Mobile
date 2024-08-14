import Link from "next/link";
export default function DashboardPage() {
  return (
    <main className="w-screen h-screen flex flex-col  gap-4">
      <header className="flex items-center justify-between p-4 border-b-2 border-secondary/10 w-full">
        <h1 className="text-2xl font-bold">Bom Prato</h1>
      </header>

      <h2 className="text-3xl font-bold text-center mt-4">Bem vindo</h2>

      <div className="flex items-center justify-center gap-4 size-full">
        <Link
          href="/dashboard/prato"
          className="border-2 rounded-xl p-4 hover:text-primary border-secondary/10"
        >
          Prato
        </Link>
        <Link
          href="/dashboard/pedido"
          className="border-2 rounded-xl p-4 hover:text-primary border-secondary/10"
        >
          Pedidos
        </Link>
      </div>
    </main>
  );
}
