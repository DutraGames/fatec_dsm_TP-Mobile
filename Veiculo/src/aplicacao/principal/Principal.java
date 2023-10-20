package aplicacao.principal;

import automovel.carro.Carro;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Carro fiat = new Carro("Fiat", "Palio", 1999, 1.6, 50);

        fiat.girarChave();

        System.out.print("Deseja abastecer? (s/n) ");
        String abastecer = scanner.next();

        if (abastecer.equals("n")) {
            return;
        }

        if (abastecer.equals("s")) {
            System.out.print("Quantos litros de gasolina deseja adicionar? ");
            double gasolina = scanner.nextDouble();
            fiat.adicionarGasolina(gasolina);

            System.out.print("Deseja Ligar o Carro? (s/n) ");
            String ligar = scanner.next();

            if (ligar.equals("n")) {
                return;
            }

            if (ligar.equals("s")) {

                fiat.girarChave();

                System.out.print("Deseja acelerar o Carro? (s/n) ");
                String acelerar = scanner.next();

                if (acelerar.equals("n")) {
                    return;
                }

                if (acelerar.equals("s")) {
                    fiat.acelerar();

                    System.out.println("O carro acelerou. " + fiat.getVelocidade());

                    while (fiat.getVelocidade() > 0) {
                        System.out.println("1- Frear");
                        System.out.println("2- Acelerar");
                        System.out.println("3- Desligar");
                        System.out.print("O que deseja fazer? ");

                        int opcao = scanner.nextInt();

                        switch (opcao) {
                            case 1:
                                fiat.frear();
                                if(fiat.getVelocidade() <= 0){
                                    System.out.println("O carro está parado..");
                                    break;
                                }else{
                                    System.out.println("O carro freou. " + fiat.getVelocidade());
                                    break;
                                }
                            case 2:
                                fiat.acelerar();
                                System.out.println("O carro acelerou. " + fiat.getVelocidade());
                                break;
                            case 3:
                                fiat.girarChave();
                                break;
                        }

                    }
                }
            }
        }
    }
}
