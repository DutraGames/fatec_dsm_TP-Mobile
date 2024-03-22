package tech.olutriz.todolistfatec.todoList.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoEntity {

  private String description;
  private int id;

  public String toJsonString() {
    return (
      "{" +
      "\"" +
      id +
      "\": {" +
      "\"description\": \"" +
      description +
      "\"," +
      "\"id\": \"" +
      Integer.toString(id) +
      "\"" +
      "}" +
      "}"
    );
  }
}
