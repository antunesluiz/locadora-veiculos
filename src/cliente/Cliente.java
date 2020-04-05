package cliente;

public class Cliente {
	private int id;
	private StatusCliente statusClientId;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String telefone;
	private String logradouro;
	private String cep;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cnh;
	private String email;
	private String senha;
	private int isAdmin;

	public Cliente(int id, StatusCliente statusClientId, String nome, String cpf, String rg, String sexo,
			String telefone, String logradouro, String cep, int numero, String bairro, String cidade, String estado,
			String pais, String cnh, String email, String senha, int isAdmin) {
		super();

		this.id = id;
		this.statusClientId = statusClientId;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cnh = cnh;
		this.email = email;
		this.senha = senha;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusCliente getStatusClientId() {
		return statusClientId;
	}

	public void setStatusClientId(StatusCliente statusClientId) {
		this.statusClientId = statusClientId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", status=" + statusClientId.getNome() + ", nome=" + nome + ", cpf=" + cpf + ", rg="
				+ rg + ", sexo=" + sexo + ", telefone=" + telefone + ", logradouro=" + logradouro + ", cep=" + cep
				+ ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais="
				+ pais + ", cnh=" + cnh + ", email=" + email + ", senha=" + senha + ", isAdmin=" + isAdmin + "]";
	}
}
