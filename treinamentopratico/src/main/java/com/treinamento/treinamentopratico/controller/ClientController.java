package com.treinamento.treinamentopratico.controller;

import java.util.List;
import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.repository.TreinamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visualization")
@Component

public class ClientController {

  private TreinamentoRepository treinamentoRepository;


  public ClientController(TreinamentoRepository treinamentoRepository) {
    this.treinamentoRepository = treinamentoRepository;

  }



  @RequestMapping(method = RequestMethod.GET)
  public List<Employee> list() {

    return treinamentoRepository.findAll();
  }

}
