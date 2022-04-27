package com.treinamento.treinamentopratico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Data

@Table(name = "Employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_idEmployee")
    private int idEmployee;

    @Column(name = "client_employee", nullable = false)
    private int clientEmployee;

    @Column(name = "name_employee", nullable = false)
    private String nameEmployee;

    @Column(name = "national_identity_employee", nullable = false)
    private String nationalIdentityEmployee;

    @Column(name = "job_position_employee", nullable = true)
    private int jobPositionEmployee;

    @Column(name = "active_employee", nullable = false)
    private boolean activeEmployee;

    @Column(name = "salary_employee", nullable = false)
    private int salaryEmployee;

    @Column(name = "type_employee", nullable = false)
    private TypeEmployee typeEmployee;

}
