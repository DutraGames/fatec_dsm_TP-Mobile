import java.util.Scanner;
import java.util.Random;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        // Professor
/* 
        Professor professor = new Professor();

        System.out.print("Nome: ");
        professor.nome = input.next();
        System.out.print("Altura: ");
        professor.altura = input.nextFloat();
        System.out.print("Formacao: ");
        professor.formacao = input.next();

        System.out.println("O professor " + professor.nome + " ira ensinar!");
        professor.ensinar();
        System.out.println("O professor " + professor.nome + " ira avaliar!");
        int nota1 = rand.nextInt(10);
        int nota2 = rand.nextInt(10);
        int nota3 = rand.nextInt(10);
        System.out.println("Sua media foi de: " + professor.avaliar(nota1, nota2, nota3));
 */

        // Aplicativo
/* 
        Aplicativo app = new Aplicativo();

        System.out.print("Nome: ");
        app.nome = input.next();
        System.out.print("Interfaces: ");
        app.interfaces = input.next();
        System.out.print("Linguagem: ");
        app.linguagem = input.next();

        app.abrir();
        System.out.println("O aplicativo " + app.nome + " foi aberto!");

        app.armazenarDados();
 */

        // Thor
        Thor thor = new Thor();

        System.out.print("Ele é deus? (s/n) ");
        String verdade = input.next();

        if (verdade.equals("s")) {
            thor.deus = true;
        } else if (verdade.equals("n")) {
            thor.deus = false;
        }

        System.out.print("Ele tem martelo? ");
        verdade = input.next();

        if (verdade.equals("s")) {
            thor.martelo = true;
        }
        else if (verdade.equals("n")) {
            thor.martelo = false;
        }

        System.out.print("Ele é forte? ");
        verdade = input.next();

        if (verdade.equals("s")) {
            thor.forte = true;
        }
        else if (verdade.equals("n")) {
            thor.forte = false;
        }

        thor.voar();
        thor.invocarRaio();
        
    }
}
