package com.treinamento.treinamentopratico.services;

import java.util.List;
import com.treinamento.treinamentopratico.exceptions.NullFieldException;
import com.treinamento.treinamentopratico.models.Client;
import com.treinamento.treinamentopratico.models.Employee;
import com.treinamento.treinamentopratico.models.JobPosition;
import com.treinamento.treinamentopratico.repositories.ClientRepository;
import com.treinamento.treinamentopratico.repositories.EmployeeRepository;
import com.treinamento.treinamentopratico.repositories.JobPositionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final ClientRepository clientRepository;
  private final JobPositionRepository jobPositionRepository;

  public EmployeeService(EmployeeRepository employeeRepository, ClientRepository clientRepository,
      JobPositionRepository jobPositionRepository) {
    this.employeeRepository = employeeRepository;
    this.clientRepository = clientRepository;
    this.jobPositionRepository = jobPositionRepository;

  }

  public List<Employee> findAll() {

    return employeeRepository.findAllWithJoin();
  }

  public Employee findById(@PathVariable("id") Integer id) {
    return employeeRepository.findById(id).get();
  }

  @Transactional
  public Employee save(Employee employee) {

    if (employee.getJobPosition().getId() == null || employee.getClient().getId() == null
        || employee.getName() == null || employee.getNationalIdentity() == null
        || employee.getBirthdate() == null || employee.getType() == null
        || employee.getSalary() == 0) {
      throw new NullFieldException(
          "Todos os campos são obrigatórios");
    }

    Client client = this.clientRepository.findById(employee.getClient().getId()).get();
    employee.setClient(client);

    JobPosition jobPosition = this.jobPositionRepository.findById(
        employee.getJobPosition().getId()).get();
    employee.setJobPosition(jobPosition);

    return employeeRepository.save(employee);
  }

  public ResponseEntity deleteById(@PathVariable("id") Integer id) {
    employeeRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
