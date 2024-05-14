package br.edu.fatecpg.blog.repositories;

import br.edu.fatecpg.blog.Models.Post;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  Post findByTitle(String title);
}
