package too.heranca.exercicio7;

public class Cliente {
	private String nome, cpf;

	public Cliente() {
		nome = cpf = "";
	}
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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

	@Override
	public String toString() {
		return String.format("nome: %s, cpf: %s", nome, cpf);
	}
}
