package br.edu.fatecpg.catalog.models;

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

  private String name;

  @OneToMany(
    mappedBy = "category",
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  private List<Product> products = new ArrayList<>();

  public Category() {}

  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
      "Category [id=" + id + ", name=" + name + ", products=" + products + "]"
    );
  }
}
