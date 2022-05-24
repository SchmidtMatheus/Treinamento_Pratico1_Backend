package com.treinamento.treinamentopratico.services;

import java.util.List;
import com.treinamento.treinamentopratico.model.EmployeeLeave;
import com.treinamento.treinamentopratico.model.enums.LeaveTypeEmployeeLeave;
import com.treinamento.treinamentopratico.repository.EmployeeLeaveRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeLeaveService {

  private final EmployeeLeaveRepository employeeLeaveRepository;

  public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository) {
    this.employeeLeaveRepository = employeeLeaveRepository;
  }


  public List<EmployeeLeave> findAll() {
    return employeeLeaveRepository.findAllWithJoin();
  }

  public EmployeeLeave findById(Integer id) {
    return employeeLeaveRepository.findById(id).get();
  }

  @Transactional
  public EmployeeLeave save(EmployeeLeave employeeLeave) {
    // validate before save
    if (LeaveTypeEmployeeLeave.CONTRIBUTORS_DEATH.equals(employeeLeave.getLeaveType())
        || LeaveTypeEmployeeLeave.TERMINATION.equals(employeeLeave.getLeaveType())) {

    }
    return employeeLeaveRepository.save(employeeLeave);
  }

  public ResponseEntity deleteById(Integer id) {
    employeeLeaveRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
