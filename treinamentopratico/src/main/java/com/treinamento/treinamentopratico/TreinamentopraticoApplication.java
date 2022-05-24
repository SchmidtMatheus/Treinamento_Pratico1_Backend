package com.treinamento.treinamentopratico;

import com.treinamento.treinamentopratico.repository.EmployeeRepository;
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
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository){
				return args -> {
		/*			employeeRepository.deleteAll();


					Employee e = new Employee();
					e.setName("Matheus");
					e.setActive(true);
					e.setNationalIdentity("07487012905");
					e.setType(TypeEmployee.INTERN);
					e.setSalary(1000);
					e.setBirthdate(LocalDate.of(1998,11,17));
					e.setClientId(1);


				employeeRepository.save(e);*/

				};

	}
	}



