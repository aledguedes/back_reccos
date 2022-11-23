package br.com.reccos.admin.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rodada")
public class Rodada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rodada;
	private LocalDate dt_rodada;
	private Boolean status;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Jogo> jogos;

	public Integer getId_rodada() {
		return id_rodada;
	}

	public void setId_rodada(Integer id_rodada) {
		this.id_rodada = id_rodada;
	}

	public LocalDate getDt_rodada() {
		return dt_rodada;
	}

	public void setDt_rodada(LocalDate dt_rodada) {
		this.dt_rodada = dt_rodada;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

}
