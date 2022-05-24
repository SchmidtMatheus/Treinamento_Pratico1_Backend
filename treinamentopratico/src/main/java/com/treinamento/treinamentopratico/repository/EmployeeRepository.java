package com.treinamento.treinamentopratico.repository;

import java.util.List;
import com.treinamento.treinamentopratico.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  @Query(value = "SELECT e.*, jp.name as jobPositionName, c.name as clientName FROM employee e inner join job_position jp on jp.id = e.job_position inner join client c on e.client_id = c.id", nativeQuery = true)
  public List<Employee> findAllWithJoin();

}
