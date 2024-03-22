package tech.olutriz.todolistfatec.todoList.services;

import io.github.cdimascio.dotenv.Dotenv;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

public class JedisConnect {

  private Dotenv dotenv = Dotenv.load();

  private String RedisURL;
  Jedis jedis;
  Connection connection;

  public JedisConnect() {
    this.RedisURL = dotenv.get("REDIS_URL");
    this.jedis = new Jedis(RedisURL);
    this.connection = jedis.getConnection();
  }

  public void testCommunication() {
    System.out.println("Redis Connection: " + jedis.clientInfo());
  }
}
