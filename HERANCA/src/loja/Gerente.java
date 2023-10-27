package loja;

public class Gerente extends Funcionario {

    public Gerente(String nome, int cpf, double salario) {
        super(nome, cpf, salario);
    }

    void fecharCaixa(double valor) {
        System.out.println("Caixa Fechou com: " + valor);
    }
}
