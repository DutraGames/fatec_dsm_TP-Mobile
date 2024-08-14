package br.edu.fatecpg.blog.repositories;

import br.edu.fatecpg.blog.Models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
  Post findByTitle(String title);

  @Query(
    "SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%"
  )
  List<Post> findByKeyword(String keyword);
}
