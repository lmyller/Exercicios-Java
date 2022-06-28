package too.heranca.exercicio7;

public class Cliente {
	private String nome, cpf, usuario, senha;

	public Cliente() {
		nome = cpf = usuario = senha = "";
	}
	
	public Cliente(String nome, String cpf, String usuario, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return String.format("nome: %s, cpf: %s, usuario: %s", nome, cpf, usuario);
	}
}
