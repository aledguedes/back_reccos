package br.com.reccos.admin.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer>{

}
