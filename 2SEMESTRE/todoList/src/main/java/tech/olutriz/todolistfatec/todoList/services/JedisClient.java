package tech.olutriz.todolistfatec.todoList.services;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;
import tech.olutriz.todolistfatec.todoList.Entities.ToDoEntity;

public class JedisClient {

  private final Jedis jedis;

  public JedisClient() {
    Dotenv dotenv = Dotenv.load();
    String redisURL = dotenv.get("REDIS_URL");
    this.jedis = new Jedis(redisURL);
  }

  public String addToDo(int id, String description) {
    ToDoEntity toDo = new ToDoEntity(description, id);
    return jedis.set(Integer.toString(id), toDo.toJsonString());
  }

  public List<String> getTodos() {
    Set<String> keys = jedis.keys("*");
    String[] keysArray = keys.toArray(new String[keys.size()]);
    return jedis.mget(keysArray);
  }

  public void close() {
    jedis.close();
  }

  public void testCommunication() {
    System.out.println("Redis Connection: " + jedis.ping());
  }
}
