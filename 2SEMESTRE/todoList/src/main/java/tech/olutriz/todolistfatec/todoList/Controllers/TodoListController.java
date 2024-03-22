package tech.olutriz.todolistfatec.todoList.Controllers;

import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.olutriz.todolistfatec.todoList.services.JedisClient;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

  private final JedisClient jedisClient = new JedisClient();

  @PostMapping("/add")
  public String addTodo() {
    return jedisClient.addToDo(0, "teste");
  }

  @GetMapping("/get")
  public List<String> getTodos() {
    return jedisClient.getTodos();
  }
}
