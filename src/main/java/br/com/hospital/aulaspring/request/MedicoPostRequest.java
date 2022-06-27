package br.com.hospital.aulaspring.request;

//essa class pega as inf da tela
public class MedicoPostRequest {
	private Integer idMedico;
	private String nome;
	private String crm;
	private String telefone;
	private String tipo;
	
	
	
	public MedicoPostRequest() {
		// TODO Auto-generated constructor stub
	}



	public MedicoPostRequest(Integer idMedico, String nome, String crm, String telefone, String tipo) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.tipo = tipo;
	}



	public Integer getIdMedico() {
		return idMedico;
	}



	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCrm() {
		return crm;
	}



	public void setCrm(String crm) {
		this.crm = crm;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	

	
	
}
