package com.treinamento.treinamentopratico.repository;

import java.util.List;
import com.treinamento.treinamentopratico.model.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {

  @Query(value = "SELECT el.*, e.name as employeeName, c.name as clientName FROM employee e inner join employee_leave el on e.id = el.employee_id inner join client c on el.client_id = c.id", nativeQuery = true)
  public List<EmployeeLeave> findAllWithJoin();

@Query(value = "SELECT employee_id FROM employee_leave el WHERE el.leave_type = 'CONTRIBUTORS_DEATH' OR el.leave_type = 'TERMINATION'", nativeQuery = true)
  public List<EmployeeLeave> findByEmployeeIdAndLeaveType();
}
