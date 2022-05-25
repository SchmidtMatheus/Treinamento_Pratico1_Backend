package com.treinamento.treinamentopratico.controller.employee;

import com.treinamento.treinamentopratico.model.Client;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.model.JobPosition;

public class EmployeeMapper {

  public static Employee toEntity(EmployeeRequest employeeRequest) {

    JobPosition jobPosition = new JobPosition();
    Client client = new Client();
    Employee employee = new Employee();

    client.setId(employeeRequest.getClientId());
    jobPosition.setId(employeeRequest.getJobPositionId());
    employee.setClient(client);
    employee.setJobPosition(jobPosition);
    employee.setName(employeeRequest.getName());
    employee.setActive(employeeRequest.isActive());
    employee.setNationalIdentity(employeeRequest.getNationalIdentity());
    employee.setType(employeeRequest.getTypeEmployee());
    employee.setSalary(employeeRequest.getSalary());
    employee.setBirthdate(employeeRequest.getBirthdate());

    return employee;
  }

  public static Employee toEntity(EmployeeRequest employeeRequest, Integer id) {
    Employee employee = toEntity(employeeRequest);
    employee.setId(id);

    return employee;
  }

  public static EmployeeResponse toResponse(Employee employee) {
    EmployeeResponse employeeResponse = new EmployeeResponse();

    employeeResponse.setClientId(employee.getClient().getId());
    employeeResponse.setClientName(employee.getClient().getName());
    employeeResponse.setJobPositionId(employee.getJobPosition().getId());
    employeeResponse.setJobPositionName(employee.getJobPosition().getName());

    employeeResponse.setId(employee.getId());
    employeeResponse.setName(employee.getName());
    employeeResponse.setActive(employee.isActive());
    employeeResponse.setNationalIdentity(employee.getNationalIdentity());
    employeeResponse.setTypeEmployee(employee.getType());
    employeeResponse.setSalary(employee.getSalary());
    employeeResponse.setBirthdate(employee.getBirthdate());

    return employeeResponse;
  }

}
