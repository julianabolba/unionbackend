package model;

public class Cliente {
	
	private int id;
	private String nome;
	private String genero;
	private String cpf;
	private String nascimento;
	private String email;
	private String telefone;
	private String busca;
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public String getBusca() {
		return busca;
	}
	public void setBusca(String busca) {
		this.busca = busca;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", genero=" + genero + ", cpf=" + cpf + ", nascimento=" + nascimento + ", email=" + email + ", telefone=" + telefone + ", busca=" + busca + ", situacao="
				+ situacao + "]";
	}
	
	

}
