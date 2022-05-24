package com.treinamento.treinamentopratico.controller.jobPosition;

import java.util.ArrayList;
import java.util.List;
import com.treinamento.treinamentopratico.model.JobPosition;
import com.treinamento.treinamentopratico.services.JobPositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job-position")
@Component
public class JobPositionController {

  private JobPositionService jobPositionService;

  public JobPositionController(JobPositionService jobPositionService) {
    this.jobPositionService = jobPositionService;
  }

  @GetMapping("/visualization")
  public List<JobPositionResponse> list() {
    ArrayList<JobPositionResponse> jobPositionList = new ArrayList<>();
    jobPositionService.findAll().forEach(jobPosition -> {
      jobPositionList.add(JobPositionMapper.toResponse(jobPosition));
    });
    return jobPositionList;
  }

  @GetMapping("/visualization/{id}")
  public JobPositionResponse findId(@PathVariable("id") Integer id) {
    JobPosition jobPosition = jobPositionService.findById(id);
    return JobPositionMapper.toResponse(jobPosition);
  }

  @PostMapping("/create")
  public JobPosition create(@RequestBody JobPositionRequest jobPositionRequest) {
    JobPosition jobPosition = JobPositionMapper.toEntity(jobPositionRequest);
    return jobPositionService.save(jobPosition);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") Integer id) {
    jobPositionService.deleteById(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping("/edit/{id}")
  public JobPosition edit(@PathVariable("id") Integer id,
      @RequestBody JobPositionRequest jobPositionRequest) {
    JobPosition jobPosition = JobPositionMapper.toEntity(jobPositionRequest, id);
    return jobPositionService.save(jobPosition);
  }

}
