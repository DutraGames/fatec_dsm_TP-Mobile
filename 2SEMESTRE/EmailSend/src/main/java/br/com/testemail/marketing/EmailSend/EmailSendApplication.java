package br.com.testemail.marketing.EmailSend;

import br.com.testemail.marketing.EmailSend.API.services.ConsomeAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSendApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(EmailSendApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ConsomeAPI consomeApi = new ConsomeAPI();
    String json = consomeApi.lerJson(
      "https://jsonplaceholder.typicode.com/comments"
    );

    System.out.println(json);
  }
}
