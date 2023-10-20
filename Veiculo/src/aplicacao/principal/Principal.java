package aplicacao.principal;
import automovel.carro.Carro;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Carro fiat = new Carro("Fiat", "Palio", 1999, 1.6, 50);
        fiat.girarChave();
        fiat.acelerar();
    }
}
