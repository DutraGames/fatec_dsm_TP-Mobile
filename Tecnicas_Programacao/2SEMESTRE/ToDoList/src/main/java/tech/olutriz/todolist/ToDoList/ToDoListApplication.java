package tech.olutriz.todolist.ToDoList;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ToDoListApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Scanner scanner = new Scanner(System.in);

    Jedis jedis = new Jedis(
      "redis://default:Eksp4K0OpXDGjjMua3g5fuPXkgxKqkFW@redis-14724.c308.sa-east-1-1.ec2.cloud.redislabs.com:14724"
    );
    Connection connection = jedis.getConnection();

    System.out.println("Connection: " + connection.ping());

    try {
      int opcao;
      do {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Listar Tarefas");
        System.out.println("4. Marcar Tarefa Concluída");
        System.out.println("5. Remover Tarefas Concluídas");
        System.out.println("6. Sair");

        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
          case 1:
            System.out.println("Digite o ID da tarefa:");
            String id = scanner.nextLine();
            System.out.println("Digite a descrição da tarefa:");
            String descricao = scanner.nextLine();
            jedis.hset("tarefas", id, descricao);
            break;
          case 2:
            Map<String, String> tarefas = jedis.hgetAll("tarefas");
            System.out.println("=================================");
            System.out.println("Lista de Tarefas:");
            for (Map.Entry<String, String> entry : tarefas.entrySet()) {
              System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("=================================");
            break;
          case 3:
            Map<String, String> tarefasConcluídas = jedis.hgetAll(
              "tarefas_concluidas"
            );
            System.out.println("=================================");
            System.out.println("Lista de Tarefas Concluídas:");
            for (Map.Entry<String, String> entry : tarefasConcluídas.entrySet()) {
              System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("=================================");
            break;
          case 4:
            System.out.println("Digite o ID da tarefa concluída:");
            String idConcluida = scanner.nextLine();
            jedis.hset(
              "tarefas_concluidas",
              idConcluida,
              jedis.hget("tarefas", idConcluida)
            );
            jedis.hdel("tarefas", idConcluida);
            break;
          case 5:
            Set<String> idsTarefasConcluidas = jedis.hkeys(
              "tarefas_concluidas"
            );
            for (String iditificated : idsTarefasConcluidas) {
              jedis.hdel("tarefas_concluidas", iditificated);
            }
            break;
          case 6:
            System.out.println("Saindo...");
            break;
          default:
            System.out.println("Opção inválida.");
        }
      } while (opcao != 5);
    } catch (JedisConnectionException e) {
      System.err.println(
        "Não foi possível conectar ao servidor Redis. Verifique suas credenciais e conexão com a internet."
      );
    } finally {
      jedis.close();
      scanner.close();
    }

    jedis.close();
  }
}
