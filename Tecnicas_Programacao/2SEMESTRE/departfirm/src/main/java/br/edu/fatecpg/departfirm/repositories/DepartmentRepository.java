package br.edu.fatecpg.departfirm.repositories;

import br.edu.fatecpg.departfirm.models.Department;
import br.edu.fatecpg.departfirm.models.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  List<Department> findByName(String name);

  @Query(
    "SELECT DISTINCT d FROM Department d JOIN d.employees e WHERE e.name = :employeeName"
  )
  List<Department> findByEmployeeName(String employeeName);

  @Query(
    "SELECT e FROM Department d JOIN d.employees e WHERE d.name = :departmentName AND e.salary > :salary"
  )
  List<Employee> findEmployeesWithSalaryGreaterThanInDepartment(
    double salary,
    String departmentName
  );
}
