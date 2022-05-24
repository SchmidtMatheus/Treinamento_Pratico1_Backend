package com.treinamento.treinamentopratico.controller.employeeLeave;

import com.treinamento.treinamentopratico.model.Client;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.model.EmployeeLeave;

public class EmployeeLeaveMapper {

  public static EmployeeLeave toEntity(EmployeeLeaveRequest employeeLeaveRequest) {
    Employee employee = new Employee();
    Client client = new Client();
    EmployeeLeave employeeLeave = new EmployeeLeave();

    employee.setId(employeeLeaveRequest.getEmployeeId());
    client.setId(employeeLeaveRequest.getClientId());
    employeeLeave.setEmployee(employee);
    employeeLeave.setClient(client);
    employeeLeave.setLeaveDate(employeeLeaveRequest.getLeaveDate());
    employeeLeave.setReturnDate(employeeLeaveRequest.getReturnDate());
    employeeLeave.setNumberDays(employeeLeaveRequest.getNumberDays());
    employeeLeave.setLeaveType(employeeLeaveRequest.getLeaveType());
    employeeLeave.setType(employeeLeaveRequest.getType());

    return employeeLeave;
  }

  public static EmployeeLeave toEntity(EmployeeLeaveRequest employeeLeaveRequest, Integer id) {
    EmployeeLeave employeeLeave = toEntity(employeeLeaveRequest);
    employeeLeave.setId(id);
    return employeeLeave;
  }

  public static EmployeeLeaveResponse toResponse(EmployeeLeave employeeLeave) {
    EmployeeLeaveResponse employeeLeaveResponse = new EmployeeLeaveResponse();

    employeeLeaveResponse.setId(employeeLeave.getId());
    employeeLeaveResponse.setClientId(employeeLeave.getClient().getId());
    employeeLeaveResponse.setClientName(employeeLeave.getClient().getName());
    employeeLeaveResponse.setEmployeeId(employeeLeave.getEmployee().getId());
    employeeLeaveResponse.setEmployeeName(employeeLeave.getEmployee().getName());
    employeeLeaveResponse.setLeaveDate(employeeLeave.getLeaveDate());
    employeeLeaveResponse.setReturnDate(employeeLeave.getReturnDate());
    employeeLeaveResponse.setNumberDays(employeeLeave.getNumberDays());
    employeeLeaveResponse.setLeaveType(employeeLeave.getLeaveType());
    employeeLeaveResponse.setType(employeeLeave.getType());

    return employeeLeaveResponse;
  }

}
