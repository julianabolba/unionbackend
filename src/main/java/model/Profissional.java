package model;

public class Profissional {
	
	private int id;
	private String nome;
	private String area;
	private String cpf;
	private String nascimento;
	private String email;
	private String telefone;
	private String ajuda;
	private String situacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getAjuda() {
		return ajuda;
	}
	public void setAjuda(String ajuda) {
		this.ajuda = ajuda;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", area=" + area + ", cpf=" + cpf + ", nascimento=" + nascimento + ", email=" + email + ", telefone=" + telefone + ", ajuda=" + ajuda + ", situacao="
				+ situacao + "]";
	}
	
	

}
