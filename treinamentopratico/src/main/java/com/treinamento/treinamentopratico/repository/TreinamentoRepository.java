package com.treinamento.treinamentopratico.repository;

import com.treinamento.treinamentopratico.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentoRepository extends JpaRepository<Employee, Integer> {
    

    
}
