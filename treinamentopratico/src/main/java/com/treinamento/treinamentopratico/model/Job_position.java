package com.treinamento.treinamentopratico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Data

public class Job_position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("_id")
  private int idJobPosition;

  @Column(name = "name", nullable = false)
  private int nameJobPosition;

}
