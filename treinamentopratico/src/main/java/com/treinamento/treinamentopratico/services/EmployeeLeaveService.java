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
  public EmployeeLeave save(EmployeeLeave employeeLeave) throws IllegalArgumentException{
    // validate before save
    if (LeaveTypeEmployeeLeave.CONTRIBUTORS_DEATH.equals(employeeLeave.getLeaveType())
        || LeaveTypeEmployeeLeave.TERMINATION.equals(employeeLeave.getLeaveType())) {

      Integer countEmployeeId = employeeLeaveRepository.countByEmployeeIdAndTerminationsType(employeeLeave.getEmployee().getId());

      if (countEmployeeId > 0) {
   //     ResponseEntity.badRequest().build();
   //     return ResponseEntity.badRequest().build();
        IllegalArgumentException error = new IllegalArgumentException("400 - Bad Request");
        throw error;
      } else {
        ResponseEntity.accepted().build();
        return employeeLeaveRepository.save(employeeLeave);
      }
    } else {
      return employeeLeaveRepository.save(employeeLeave);
    }
  }

  public ResponseEntity deleteById(Integer id) {
    employeeLeaveRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
