package br.com.reccos.admin.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}
