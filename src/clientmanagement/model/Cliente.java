package clientmanagement.model;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String dtNasc;
	private String sexo;
	private String estadoCivil;
	private boolean ativo;
	
	public Cliente(String cpf, String nome, String email, String dtNasc, String sexo, String estadoCivil,
			boolean ativo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.ativo = ativo;
	}
	
	
	public Cliente(String nome, String email, String dtNasc, String sexo, String estadoCivil, boolean ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.ativo = ativo;
	}
	
	public Cliente(String cpf) {
		super();
		this.cpf = cpf;
	}


	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDtnasc() {
		return dtNasc;
	}
	public void setDtnasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

}
