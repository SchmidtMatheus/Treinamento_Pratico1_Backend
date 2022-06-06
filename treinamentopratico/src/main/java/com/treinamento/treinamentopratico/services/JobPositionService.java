package com.treinamento.treinamentopratico.services;

import java.util.List;
import com.treinamento.treinamentopratico.models.JobPosition;
import com.treinamento.treinamentopratico.repositories.JobPositionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class JobPositionService {

  private final JobPositionRepository jobPositionRepository;

  public JobPositionService(JobPositionRepository jobPositionRepository) {
    this.jobPositionRepository = jobPositionRepository;
  }

  public List<JobPosition> findAll() {

    return jobPositionRepository.findAll();
  }

  public JobPosition findById(@PathVariable("id") Integer id) {
    return jobPositionRepository.findById(id).get();
  }

  @Transactional
  public JobPosition save(JobPosition jobPosition) {
    return jobPositionRepository.save(jobPosition);
  }

  public ResponseEntity deleteById(@PathVariable("id") Integer id) {
    jobPositionRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }
}
