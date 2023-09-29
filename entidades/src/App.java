import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Professor professor = new Professor();
        Scanner input = new Scanner(System.in);

        professor.nome = "João";
        professor.altura = 1.80f;
        professor.formacao = "Mestrado";

        professor.ensinar();
    }
}
