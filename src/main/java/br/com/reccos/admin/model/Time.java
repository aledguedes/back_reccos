package br.com.reccos.admin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String initials;
	private String president;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String uf;
	private String img_scudo;
	private String img_stadium;
	private String phone;
	private Boolean status;
	private String surname;
	private LocalDate dt_nascimento;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "times_id")
//	private List<Atleta> atletas;

	@ManyToOne
	private Liga liga;

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

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getImg_scudo() {
		return img_scudo;
	}

	public void setImg_scudo(String img_scudo) {
		this.img_scudo = img_scudo;
	}

	public String getImg_stadium() {
		return img_stadium;
	}

	public void setImg_stadium(String img_stadium) {
		this.img_stadium = img_stadium;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

//	public List<Atleta> getAtletas() {
//		return atletas;
//	}

//	public void setAtletas(List<Atleta> atletas) {
//		this.atletas = atletas;
//	}

	public String getSurname() {
		return surname;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
