package com.treinamento.treinamentopratico.controller.employee;

import java.util.ArrayList;
import java.util.List;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@Component

public class EmployeeController {

  private EmployeeService employeeService;


  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;

  }

  @GetMapping("/visualization")
  public List<EmployeeResponse> list() {
    ArrayList<EmployeeResponse> employeeList = new ArrayList<>();
    employeeService.findAll().forEach(employee -> {
      employeeList.add(EmployeeMapper.toResponse(employee));
    });
    return employeeList;
  }

  @GetMapping("/visualization/{id}")
  public EmployeeResponse findId(@PathVariable("id") Integer id) {
    Employee employee = employeeService.findById(id);
    return EmployeeMapper.toResponse(employee);
  }

  @PostMapping("/create")
  public Employee create(@RequestBody EmployeeRequest employeeRequest) {
    Employee employee = EmployeeMapper.toEntity(employeeRequest);
    return employeeService.save(employee);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") Integer id) {
    employeeService.deleteById(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping("/edit/{id}")
  public Employee edit(@PathVariable("id") Integer id,
      @RequestBody EmployeeRequest employeeRequest) {
    Employee employee = EmployeeMapper.toEntity(employeeRequest, id);
    return employeeService.save(employee);
  }

}
