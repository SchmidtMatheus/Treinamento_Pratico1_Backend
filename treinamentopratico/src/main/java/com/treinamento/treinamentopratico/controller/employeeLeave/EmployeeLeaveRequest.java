package com.treinamento.treinamentopratico.controller.employeeLeave;

import java.sql.Date;
import com.treinamento.treinamentopratico.model.enums.LeaveTypeEmployeeLeave;
import com.treinamento.treinamentopratico.model.enums.TypeEmployeeLeave;
import lombok.Data;

@Data
public class EmployeeLeaveRequest {

  private int id;
  private int clientId;
  private int employeeId;
  private Date leaveDate;
  private Date returnDate;
  private int numberDays;
  private TypeEmployeeLeave type;
  private LeaveTypeEmployeeLeave leaveType;
}
