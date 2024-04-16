package br.com.testemail.marketing.EmailSend;

import br.com.testemail.marketing.EmailSend.API.model.Comment;
import br.com.testemail.marketing.EmailSend.API.services.ConsomeAPI;
import br.com.testemail.marketing.EmailSend.API.services.ConvertData;
import java.util.ArrayList;
import java.util.List;
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
    ConvertData convertData = new ConvertData();
    List<Comment> comments = new ArrayList<>();

    comments = convertData.convertData(json, Comment.class);

    comments.stream().forEach(System.out::println);
  }
}
