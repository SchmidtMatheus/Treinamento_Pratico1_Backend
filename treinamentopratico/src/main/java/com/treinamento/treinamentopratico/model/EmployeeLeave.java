package com.treinamento.treinamentopratico.model;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.treinamento.treinamentopratico.model.enums.LeaveTypeEmployeeLeave;
import com.treinamento.treinamentopratico.model.enums.TypeEmployeeLeave;
import lombok.Data;

@Entity
@Data

@Table(name = "employee_leave")

public class EmployeeLeave {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

//  @Column(name = "client_id", nullable = false)
//  private int clientId;

//  @Column(name = "employee_id", nullable = false)
// private int employeeId;

  @Column(name = "leave_date", nullable = false)
  private Date leaveDate;

  @Column(name = "number_days")
  private int numberDays;

  @Column(name = "return_date")
  private Date returnDate;

  @Column(name = "type")
  private TypeEmployeeLeave type;

  @Column(name = "leave_type")
  private LeaveTypeEmployeeLeave leaveType;

  @OneToOne(cascade= CascadeType.MERGE)
  @JoinColumn(name = "employee_id",nullable=false)
  private Employee employee;

  @OneToOne(cascade= CascadeType.MERGE)
  @JoinColumn(name = "client_id",nullable=false)
  private Client client;

}
