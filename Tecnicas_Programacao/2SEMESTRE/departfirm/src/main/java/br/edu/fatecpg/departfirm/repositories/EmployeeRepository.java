package br.edu.fatecpg.departfirm.repositories;

import br.edu.fatecpg.departfirm.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
