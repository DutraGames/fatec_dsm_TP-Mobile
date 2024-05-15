package br.edu.fatecpg.catalog.repositories;

import br.edu.fatecpg.catalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
