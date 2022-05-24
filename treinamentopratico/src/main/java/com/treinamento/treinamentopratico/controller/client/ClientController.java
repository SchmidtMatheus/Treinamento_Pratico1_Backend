package com.treinamento.treinamentopratico.controller.client;


import java.util.ArrayList;
import java.util.List;
import com.treinamento.treinamentopratico.model.Client;
import com.treinamento.treinamentopratico.services.ClientService;
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
@RequestMapping("/api/client")
@Component

public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/visualization")
  public List<ClientResponse> list() {
    ArrayList<ClientResponse> clientList = new ArrayList<>();
    clientService.findAll().forEach(client -> {
      clientList.add(ClientMapper.toResponse(client));
    });
    return clientList;
  }

  @GetMapping("/visualization/{id}")
  public ClientResponse findId(@PathVariable("id") Integer id) {
    Client client = clientService.findById(id);
    return ClientMapper.toResponse(client);
  }

  @PostMapping("/create")
  public Client create(@RequestBody ClientRequest clientRequest) {
    Client client = ClientMapper.toEntity(clientRequest);
    return clientService.save(client);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") Integer id) {
    clientService.deleteById(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping("/edit/{id}")
  public Client edit(@PathVariable("id") Integer id, @RequestBody ClientRequest clientRequest) {
    Client client = ClientMapper.toEntity(clientRequest, id);
    return clientService.save(client);
  }
}
