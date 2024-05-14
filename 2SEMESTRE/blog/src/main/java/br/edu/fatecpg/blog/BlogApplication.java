package br.edu.fatecpg.blog;

import br.edu.fatecpg.blog.Models.Comment;
import br.edu.fatecpg.blog.Models.Post;
import br.edu.fatecpg.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

  @Autowired
  private PostRepository postRepository;

  public static void main(String[] args) {
    SpringApplication.run(BlogApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /*     Post post1 = new Post("Post 1", "Content 1");
    Post post2 = new Post("Post 2", "Content 2");

    Comment comment1 = new Comment("Name 1", "Content 1");
    Comment comment2 = new Comment("Name 2", "Content 2");
    Comment comment3 = new Comment("Name 3", "Content 3");
    Comment comment4 = new Comment("Name 4", "Content 4");

    post1.setComments(comment1);
    post1.setComments(comment2);
    post2.setComments(comment3);
    post2.setComments(comment4);

    postRepository.save(post1);
    postRepository.save(post2);
 */

    System.out.println("------------------------------------------");

    System.out.println("All Posts: ");
    postRepository.findAll().forEach(System.out::println);

    System.out.println("------------------------------------------");

    System.out.println("Post for title: ");
    System.out.println(postRepository.findByTitle("Post 1"));

    System.out.println("------------------------------------------");

    System.out.println("Post for keyword: ");
    postRepository.findByKeyword("Content").forEach(System.out::println);

    System.out.println("------------------------------------------");
  }
}
