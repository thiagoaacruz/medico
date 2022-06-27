package br.com.hospital.aulaspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer idUsuario;
	
	@Column(name="nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name="login", length = 50, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 50, nullable = false)
	private String senha;
	
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	public Usuario(Integer idUsuario, String nome, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
	
	
	
}
