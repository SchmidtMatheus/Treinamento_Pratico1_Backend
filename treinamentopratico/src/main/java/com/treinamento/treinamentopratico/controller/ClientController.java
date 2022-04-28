package com.treinamento.treinamentopratico.controller;

import java.util.List;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.repository.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visualization")
@Component

public class ClientController {

  private EmployeeRepository employeeRepository;


  public ClientController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;

  }



  @RequestMapping(method = RequestMethod.GET)
  public List<Employee> list() {

    return employeeRepository.findAll();
  }

}
