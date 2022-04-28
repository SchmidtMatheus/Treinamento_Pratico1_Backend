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

@Table(name = "client")

public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("_id")
  private int idClient;

  @Column(name = "name", nullable = false)
  private int nameClient;
}
