package loja;

public class Faxineiro extends Funcionario {
    
    Faxineiro(String nome, int cpf, double salario) {
        super(nome, cpf, salario);
    }

    void solicitarMaterial(String material){
        System.out.println("Favor comprar o material " + material);
    }

}
