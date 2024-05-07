package br.edu.fatecpg.departfirm;

import br.edu.fatecpg.departfirm.models.Department;
import br.edu.fatecpg.departfirm.models.Employee;
import br.edu.fatecpg.departfirm.repositories.DepartmentRepository;
import br.edu.fatecpg.departfirm.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartFirmApplication implements CommandLineRunner {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  public static void main(String[] args) {
    SpringApplication.run(DepartFirmApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Employee employee = new Employee("Joao");
    Department department = new Department("Informatica");

    //departmentRepository.save(department);
    /* employee.setDepartment(department); */
    //employeeRepository.save(employee);
    /* department.setEmployees(employee);
    departmentRepository.save(department); */

    System.out.println(employeeRepository.findAll());
    System.out.println("----------------------------");
    System.out.println(departmentRepository.findAll());
  }
}
