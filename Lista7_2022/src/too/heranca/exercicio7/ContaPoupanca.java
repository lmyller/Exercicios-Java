package too.heranca.exercicio7;

public final class ContaPoupanca extends ContaBancaria {

	public ContaPoupanca() {}

	public ContaPoupanca(int numeroAgencia, String numeroConta, String senha, float valor, String dataAbertura,
			Cliente cliente) {
		super(numeroAgencia, numeroConta, senha, valor, dataAbertura, cliente);
	}

}
