package com.treinamento.treinamentopratico.services;

import java.util.List;
import com.treinamento.treinamentopratico.models.Client;
import com.treinamento.treinamentopratico.repositories.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ClientService {

  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public List<Client> findAll() {

    return clientRepository.findAll();
  }

  public Client findById(@PathVariable("id") Integer id) {
    return clientRepository.findById(id).get();
  }

  @Transactional
  public Client save(Client client) {
    return clientRepository.save(client);
  }

  public ResponseEntity deleteById(@PathVariable("id") Integer id) {
    clientRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
