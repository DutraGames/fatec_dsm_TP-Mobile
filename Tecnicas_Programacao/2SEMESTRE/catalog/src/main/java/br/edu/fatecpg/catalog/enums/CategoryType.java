package br.edu.fatecpg.catalog.enums;

public enum CategoryType {
  SMARTPHONES("Smartphones"),
  GAMES("Games"),
  TVS("TVs"),
  NOTEBOOKS("Notebooks");

  private String name;

  CategoryType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
