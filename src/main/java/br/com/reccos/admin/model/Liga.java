package br.com.reccos.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "liga")
public class Liga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate dt_inicio = LocalDate.now();
	private LocalDate dt_fim = LocalDate.now();
	private String type_liga;
	private String campo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ligas_id")
	private List<Time> times;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ligas_id")
	private List<Arbitro> arbitros;

	public Liga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public LocalDate getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(LocalDate dt_fim) {
		this.dt_fim = dt_fim;
	}

	public String getType_liga() {
		return type_liga;
	}

	public void setType_liga(String type_liga) {
		this.type_liga = type_liga;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public List<Arbitro> getArbitros() {
		return arbitros;
	}

	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

}
