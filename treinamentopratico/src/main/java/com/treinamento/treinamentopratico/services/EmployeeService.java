package com.treinamento.treinamentopratico.services;

import java.util.List;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository){
    this.employeeRepository = employeeRepository;

  }

  public List<Employee> findAll() {

    return employeeRepository.findAllWithJoin();
  }

  public Employee findById(@PathVariable("id") Integer id) {
    return employeeRepository.findById(id).get();
  }

  @Transactional
  public Employee save(Employee employee){

    return employeeRepository.save(employee);
  }

  public ResponseEntity deleteById(@PathVariable("id") Integer id) {
    employeeRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
