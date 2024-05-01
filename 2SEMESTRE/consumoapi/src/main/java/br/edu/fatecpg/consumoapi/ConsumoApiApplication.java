package br.edu.fatecpg.consumoapi;

import br.edu.fatecpg.consumoapi.model.Endereco;
import java.util.Scanner;
import br.edu.fatecpg.consumoapi.model.NovoEndereco;
import br.edu.fatecpg.consumoapi.repository.NovoEnderecoRepository;
import br.edu.fatecpg.consumoapi.service.ConsomeApi;
import br.edu.fatecpg.consumoapi.service.ConverteDados;
import br.edu.fatecpg.consumoapi.service.IConverteDados;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;
import java.util.List;

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner {
	@Autowired
	private NovoEnderecoRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean loop = true;
		ConsomeApi consomeApi = new ConsomeApi();
		ConverteDados converteDados = new ConverteDados();
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
			System.out.println("_____________________________");
			System.out.println("1 - Consultar um CEP");
			System.out.println("2 - Consultar todos os CEPs");
			System.out.println("3 - Sair");
			System.out.println("_____________________________");
			System.out.println("Escolha uma opção: ");
			int op = scan.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Digite o cep: ");
				String cep = scan.next();
				
				try {
					
					String json = consomeApi.retornaJson("https://viacep.com.br/ws/"+ cep +"/json/");
					Endereco endereco = converteDados.converteDados(json, Endereco.class);
					NovoEndereco end = new NovoEndereco(endereco);
					repositorio.save(end);
					System.out.println(json);
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}finally {
					System.out.println("passou");
				}
				break;
				
			case 2:
				List<NovoEndereco> enderecos = repositorio.findAll();
				enderecos.forEach(System.out::println);
				break;
				
			case 3:
				loop = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
			
		}
			
	}
}
