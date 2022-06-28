package too.heranca.exercicio7;

import java.time.LocalDate;

public final class ContaRemunerada extends ContaBancaria {

	public ContaRemunerada() {}

	public ContaRemunerada(int numeroAgencia, String numeroConta, String senha, float valor, LocalDate dataAbertura,
			Cliente cliente) {
		super(numeroAgencia, numeroConta, senha, valor, dataAbertura, cliente);
	}

}
