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

@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private int id;

    @Column(name = "client", nullable = false)
    private int clientEmployee;

    @Column(name = "name", nullable = false)
    private String nameEmployee;

    @Column(name = "national_identity", nullable = false)
    private String nationalIdentityEmployee;

    @Column(name = "job_position", nullable = true)
    private int jobPositionEmployee;

    @Column(name = "active", nullable = false)
    private boolean activeEmployee;

    @Column(name = "salary", nullable = false)
    private int salaryEmployee;

    @Column(name = "type", nullable = false)
    private TypeEmployee typeEmployee;

    @Column(name = "birthdate", nullable = false)
    private java.time.LocalDate birthdateEmployee;

}
