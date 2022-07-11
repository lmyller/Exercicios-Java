package too.heranca.exercicio7;

public final class ContaRemunerada extends ContaBancaria {

	public ContaRemunerada() {}

	public ContaRemunerada(int numeroAgencia, String numeroConta, String senha, float valor, String dataAbertura,
			Cliente cliente) {
		super(numeroAgencia, numeroConta, senha, valor, dataAbertura, cliente);
	}

}
