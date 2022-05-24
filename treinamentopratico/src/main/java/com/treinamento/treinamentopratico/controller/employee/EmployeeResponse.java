package com.treinamento.treinamentopratico.controller.employee;

import java.sql.Date;
import com.treinamento.treinamentopratico.model.enums.TypeEmployee;
import lombok.Data;

@Data
public class EmployeeResponse {

  private int id;
  private String name;
  private String nationalIdentity;
  private int clientId;
  private String jobPositionName;
  private String clientName;
  private float salary;
  private int jobPositionId;
  private TypeEmployee typeEmployee;
  private boolean active;
  private Date birthdate;
}
