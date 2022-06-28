package too.heranca.exercicio7;

import java.time.LocalDate;

public final class ContaPoupanca extends ContaBancaria {

	public ContaPoupanca() {}

	public ContaPoupanca(int numeroAgencia, String numeroConta, String senha, float valor, LocalDate dataAbertura,
			Cliente cliente) {
		super(numeroAgencia, numeroConta, senha, valor, dataAbertura, cliente);
	}

}
