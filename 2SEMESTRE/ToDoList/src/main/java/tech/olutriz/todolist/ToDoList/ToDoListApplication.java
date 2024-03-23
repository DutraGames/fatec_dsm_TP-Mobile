package tech.olutriz.todolist.ToDoList;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ToDoListApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    String redisUrl = dotenv.get("REDIS_URL");

    Jedis jedis = new Jedis(redisUrl);
    Connection connection = jedis.getConnection();

    System.out.println(connection.ping());
  }
}
