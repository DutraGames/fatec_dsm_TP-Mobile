package br.edu.fatecpg.catalog.models;

import br.edu.fatecpg.catalog.enums.CategoryType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private CategoryType type;

  @OneToMany(
    mappedBy = "category",
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  private List<Product> products = new ArrayList<>();

  public Category() {}

  public Category(CategoryType type) {
    this.type = type;
  }

  public CategoryType getType() {
    return type;
  }

  public void setType(CategoryType type) {
    this.type = type;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(Product product) {
    product.setCategory(this);
    this.products.add(product);
  }

  @Override
  public String toString() {
    return (
      "Category [id=" + id + ", type=" + type + ", products=" + products + "]"
    );
  }
}
