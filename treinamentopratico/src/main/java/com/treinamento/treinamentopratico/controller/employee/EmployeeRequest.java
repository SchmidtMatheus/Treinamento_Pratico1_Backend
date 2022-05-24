package com.treinamento.treinamentopratico.controller.employee;

import java.sql.Date;
import com.treinamento.treinamentopratico.model.enums.TypeEmployee;
import lombok.Data;

@Data
public class EmployeeRequest {

  private String name;
  private String nationalIdentity;
  private int clientId;
  private float salary;
  private int jobPositionId;
  private TypeEmployee typeEmployee;
  private boolean active;
  private Date birthdate;
}
