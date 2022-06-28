package too.heranca.exercicio7;

import java.time.LocalDate;

public final class ContaCorrente extends ContaBancaria {

	private static int quantidadeContasCorrentes;
	
	public ContaCorrente() {}

	public ContaCorrente(int numeroAgencia, String numeroConta, String senha, float valor, LocalDate dataAbertura,
			Cliente cliente) {
		super(numeroAgencia, numeroConta, senha, valor, dataAbertura, cliente);
		quantidadeContasCorrentes++;
	}

	public static int getQuantidadeContasCorrentes() {
		return quantidadeContasCorrentes;
	}
}
