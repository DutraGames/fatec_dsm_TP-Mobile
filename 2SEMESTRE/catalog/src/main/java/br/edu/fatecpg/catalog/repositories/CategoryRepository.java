package br.edu.fatecpg.catalog.repositories;

import br.edu.fatecpg.catalog.enums.CategoryType;
import br.edu.fatecpg.catalog.models.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByType(CategoryType type);

  @Query("SELECT c FROM Category c WHERE LEFT(c.type.toString(), 1) = :letter")
  List<Category> findByTypeStartingWith(String letter);
}
