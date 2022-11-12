package br.com.reccos.admin.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "liga")
public class Liga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate dt_start;
	private LocalDate dt_end;
	private String system;
	private String mode;
	private Boolean status;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ligas_id")
//	private List<Time> times;

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

	public LocalDate getDt_start() {
		return dt_start;
	}

	public void setDt_start(LocalDate dt_start) {
		this.dt_start = dt_start;
	}

	public LocalDate getDt_end() {
		return dt_end;
	}

	public void setDt_end(LocalDate dt_end) {
		this.dt_end = dt_end;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

//	public List<Time> getTimes() {
//		return times;
//	}
//
//	public void setTimes(List<Time> times) {
//		this.times = times;
//	}

	public List<Arbitro> getArbitros() {
		return arbitros;
	}

	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
