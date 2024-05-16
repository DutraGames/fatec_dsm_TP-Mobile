package br.edu.fatecpg.catalog;

import br.edu.fatecpg.catalog.enums.CategoryType;
import br.edu.fatecpg.catalog.models.Category;
import br.edu.fatecpg.catalog.models.Product;
import br.edu.fatecpg.catalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {

  @Autowired
  private CategoryRepository categoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(CatalogApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /* Category category = new Category(CategoryType.SMARTPHONES);
    Category category2 = new Category(CategoryType.GAMES);

    Product product = new Product("iPhone 14", 3500.0);
    Product product2 = new Product("Xiaomi 12s", 1600.0);
    Product product3 = new Product("Xbox Series X", 4000.0);
    Product product4 = new Product("PlayStation 5", 4000.0);

    category.setProducts(product);
    category.setProducts(product2);
    category2.setProducts(product3);
    category2.setProducts(product4);

    categoryRepository.save(category);
    categoryRepository.save(category2); */

    System.out.println("--------------------------------------------------");
    System.out.println("All Categories: ");

    categoryRepository.findAll().forEach(System.out::println);

    System.out.println("--------------------------------------------------");

    System.out.println("All Products for category: ");

    categoryRepository
      .findByType(CategoryType.GAMES)
      .forEach(System.out::println);

    System.out.println("--------------------------------------------------");

    System.out.println("All Products for category starting with: ");

    categoryRepository.findByTypeStartingWith("G").forEach(System.out::println);
    System.out.println("--------------------------------------------------");
  }
}
