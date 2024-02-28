"use client";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { useRouter } from "next/navigation";
const loginSchema = z.object({
  nome: z.string().min(3, { message: "Nome muito curto" }),
  senha: z.string().min(3, { message: "Senha muito curta" }),
});

type LoginProps = z.infer<typeof loginSchema>;

export default function HomePage() {
  const { register, handleSubmit } = useForm<LoginProps>({
    resolver: zodResolver(loginSchema),
  });

  const { push } = useRouter();

  const handleLogin = (data: LoginProps) => {
    if (data.nome === "admin" && data.senha === "admin") {
      push("/dashboard");
    }
  };

  return (
    <main className="flex flex-col h-screen w-full">
      <header className="flex items-center justify-between p-4 border-b-2 border-secondary/10 w-full">
        <h1 className="text-2xl font-bold">Bom Prato</h1>
      </header>

      <section className="flex flex-col items-center justify-center size-full">
        <form
          className="border-2 border-secondary/10 rounded-lg p-8 space-y-2"
          onSubmit={handleSubmit(handleLogin)}
        >
          <h2 className="text-xl font-bold mb-4">Seja bem-vindo ao sistema</h2>

          <Label>Usuário</Label>
          <Input placeholder="Seu nome" {...register("nome")} />

          <Label>Senha</Label>
          <Input
            type="password"
            placeholder="Sua senha"
            {...register("senha")}
          />

          <Button type="submit" className="w-full">
            Entrar
          </Button>
        </form>
      </section>
    </main>
  );
}
