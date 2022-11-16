package br.com.reccos.admin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dt_start_contract;
	private LocalDate dt_end_contract;

	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time time;

	@ManyToOne
	@JoinColumn(name = "atleta_id")
	private Atleta atleta;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDt_start_contract() {
		return dt_start_contract;
	}

	public void setDt_start_contract(LocalDate dt_start_contract) {
		this.dt_start_contract = dt_start_contract;
	}

	public LocalDate getDt_end_contract() {
		return dt_end_contract;
	}

	public void setDt_end_contract(LocalDate dt_end_contract) {
		this.dt_end_contract = dt_end_contract;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

}
