package com.treinamento.treinamentopratico;

import com.treinamento.treinamentopratico.model.Employee;
import com.treinamento.treinamentopratico.model.TypeEmployee;
import com.treinamento.treinamentopratico.repository.TreinamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TreinamentopraticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentopraticoApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(TreinamentoRepository treinamentoRepository){
				return args -> {
					treinamentoRepository.deleteAll();


					Employee e = new Employee();
					e.setNameEmployee("Matheus");
					e.setActiveEmployee(true);
					e.setNationalIdentityEmployee("07487012905");
					e.setTypeEmployee(TypeEmployee.INTERN);
					e.setSalaryEmployee(1000);


				treinamentoRepository.save(e);

				};

	}

}
