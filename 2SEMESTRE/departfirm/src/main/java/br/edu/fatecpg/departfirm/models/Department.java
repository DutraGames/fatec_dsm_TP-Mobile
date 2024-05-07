package br.edu.fatecpg.departfirm.models;

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
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @OneToMany(
    mappedBy = "department",
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  private List<Employee> employees = new ArrayList<>();

  public Department() {}

  public Department(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Employee employees) {
    employees.setDepartment(this);
    this.employees.add(employees);
  }

  @Override
  public String toString() {
    return (
      "Department [id=" +
      id +
      ", name=" +
      name +
      ", employees=" +
      employees +
      "" +
      "]"
    );
  }
}
