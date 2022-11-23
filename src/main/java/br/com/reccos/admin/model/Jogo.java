package br.com.reccos.admin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jogo")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_jogo;
	private LocalDate dt_partida;
	private Boolean status;

	@ManyToOne
	@JsonIgnoreProperties({ "liga", "contratos" })
	private Time mandante;

	@ManyToOne
	@JsonIgnoreProperties({ "liga", "contratos" })
	private Time visitante;

	@ManyToOne
	@JoinColumn(name = "arbitro_id")
	private Arbitro arbitro;

	public Integer getId_jogo() {
		return id_jogo;
	}

	public void setId_jogo(Integer id_jogo) {
		this.id_jogo = id_jogo;
	}

	public LocalDate getDt_partida() {
		return dt_partida;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setDt_partida(LocalDate dt_partida) {
		this.dt_partida = dt_partida;
	}

	public Time getMandante() {
		return mandante;
	}

	public void setMandante(Time mandante) {
		this.mandante = mandante;
	}

	public Time getVisitante() {
		return visitante;
	}

	public void setVisitante(Time visitante) {
		this.visitante = visitante;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

}
