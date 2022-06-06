package com.treinamento.treinamentopratico.services;

import java.sql.Date;
import java.util.List;
import com.treinamento.treinamentopratico.exceptions.DeathOrTerminationException;
import com.treinamento.treinamentopratico.exceptions.LeaveDaysException;
import com.treinamento.treinamentopratico.exceptions.NotFoundIdException;
import com.treinamento.treinamentopratico.exceptions.NullFieldException;
import com.treinamento.treinamentopratico.models.Client;
import com.treinamento.treinamentopratico.models.Employee;
import com.treinamento.treinamentopratico.models.EmployeeLeave;
import com.treinamento.treinamentopratico.models.enums.LeaveTypeEmployeeLeave;
import com.treinamento.treinamentopratico.repositories.ClientRepository;
import com.treinamento.treinamentopratico.repositories.EmployeeLeaveRepository;
import com.treinamento.treinamentopratico.repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeLeaveService {

  private final EmployeeLeaveRepository employeeLeaveRepository;
  private final ClientRepository clientRepository;
  private final EmployeeRepository employeeRepository;

  public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository,
      EmployeeRepository employeeRepository, ClientRepository clientRepository) {
    this.employeeLeaveRepository = employeeLeaveRepository;
    this.employeeRepository = employeeRepository;
    this.clientRepository = clientRepository;
  }


  public List<EmployeeLeave> findAll() {
    return employeeLeaveRepository.findAllWithJoin();
  }

  public EmployeeLeave findById(Integer id) {

    return employeeLeaveRepository.findById(id).orElseThrow(
        () -> new NotFoundIdException("Id não encontrado, será cadastrado um novo Id")
    );
  }

  @Transactional
  public EmployeeLeave save(EmployeeLeave employeeLeave) throws IllegalArgumentException {

    // validate before save

    if (employeeLeave.getEmployee().getId() == null || employeeLeave.getClient().getId() == null
        || employeeLeave.getLeaveDate() == null || employeeLeave.getLeaveType() == null) {
      throw new NullFieldException(
          "Os campos \"Nome do funcionário\", \"Empresa\", \"Classe de afastamento\" e \"Início do afastamento\" são obrigatórios");
    }
    if (!LeaveTypeEmployeeLeave.WORK_INJURY.equals(employeeLeave.getLeaveType()) && !(
        employeeLeave.getType() == null)) {
      throw new NullFieldException(
          "O campo \"Tipo de afastamento\" deve ser nulo ");
    }

    Client client = this.clientRepository.findById(employeeLeave.getClient().getId()).get();
    employeeLeave.setClient(client);

    Employee employee = this.employeeRepository.findById(employeeLeave.getEmployee().getId()).get();
    employeeLeave.setEmployee(employee);

    if ((LeaveTypeEmployeeLeave.MATERNITY_LEAVE.equals(employeeLeave.getLeaveType())
        || LeaveTypeEmployeeLeave.PATERNITY_LEAVE.equals(employeeLeave.getLeaveType()))) {

      final long dateToNumber = 86400000L;
      final int maternityNumberDays = 180;
      final int paternityNumberDays = 20;
      final long maternityReturnDate = (
          (((employeeLeave.getLeaveDate().getTime()) / dateToNumber) + maternityNumberDays + 1)
              * (dateToNumber));
      final long paternityReturnDate = (
          (((employeeLeave.getLeaveDate().getTime()) / dateToNumber) + paternityNumberDays + 1)
              * (dateToNumber));

      if (LeaveTypeEmployeeLeave.MATERNITY_LEAVE.equals(employeeLeave.getLeaveType())) {

        if (!(employeeLeave.getNumberDays() == maternityNumberDays)
            || !(employeeLeave.getReturnDate()
            .equals(new Date(maternityReturnDate)))) {
          throw new LeaveDaysException(
              "O campo \"Tempo afastado\" deve ter o valor " + maternityNumberDays
                  + " e o valor de \"Data de retorno\" precisa ser condizente");
        }

      } else if (LeaveTypeEmployeeLeave.PATERNITY_LEAVE.equals(employeeLeave.getLeaveType())) {
        if (!(employeeLeave.getNumberDays() == paternityNumberDays)
            || !(employeeLeave.getReturnDate()
            .equals(new Date(paternityReturnDate)))) {
          throw new LeaveDaysException(
              "O campo \"Tempo afastado\" deve ter o valor " + paternityNumberDays
                  + " e o valor de \"Data de retorno\" precisa ser condizente");
        }
      }

    }
    if (LeaveTypeEmployeeLeave.CONTRIBUTORS_DEATH.equals(employeeLeave.getLeaveType())
        || LeaveTypeEmployeeLeave.TERMINATION.equals(employeeLeave.getLeaveType())) {

      Integer countEmployeeId = employeeLeaveRepository.countByEmployeeIdAndTerminationsType(
          employeeLeave.getEmployee().getId());

      if (countEmployeeId > 0) {
        throw new DeathOrTerminationException(
            "O funcionário " + employeeLeave.getEmployee().getName()
                + " já possui um registro do tipo: " + employeeLeave.getLeaveType()
                + " e não permite novos afastamentos"
        );
      } else {
        ResponseEntity.accepted().build();
        return employeeLeaveRepository.save(employeeLeave);
      }
    } else {
      return employeeLeaveRepository.save(employeeLeave);
    }
  }

  public ResponseEntity deleteById(Integer id) {
    employeeLeaveRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
