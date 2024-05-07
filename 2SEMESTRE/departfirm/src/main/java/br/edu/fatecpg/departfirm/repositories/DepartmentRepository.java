package br.edu.fatecpg.departfirm.repositories;

import br.edu.fatecpg.departfirm.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
