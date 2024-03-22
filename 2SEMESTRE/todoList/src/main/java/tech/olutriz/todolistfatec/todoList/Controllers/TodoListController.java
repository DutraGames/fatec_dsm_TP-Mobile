package tech.olutriz.todolistfatec.todoList.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.olutriz.todolistfatec.todoList.services.JedisConnect;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

  private JedisConnect jedis = new JedisConnect();

  @GetMapping("/test")
  public String testCommunication() {
    jedis.testCommunication();
    return (
      "{" +
      "  \"message\": \"Conected to Redis " +
      "\"" +
      "," +
      "\"error\":" +
      false +
      "}"
    );
  }
}
