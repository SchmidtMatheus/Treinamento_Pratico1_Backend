package com.treinamento.treinamentopratico.repository;

import com.treinamento.treinamentopratico.model.Job_position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository<Job_position, Integer>{

}
