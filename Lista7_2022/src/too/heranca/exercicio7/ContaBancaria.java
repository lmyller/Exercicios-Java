package too.heranca.exercicio7;

public class ContaBancaria {
	private int numeroAgencia;
	private String numeroConta, senha;
	private float valor;
	private String dataAbertura;
	private Cliente cliente;
	
	public ContaBancaria() {
		numeroConta = senha = "";
	}

	public ContaBancaria(int numeroAgencia, String numeroConta, String senha, float valor, String dataAbertura,
			Cliente cliente) {
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.senha = senha;
		this.valor = valor;
		this.dataAbertura = dataAbertura;
		this.cliente = cliente;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public boolean saque(float valor) {
		if(valor >= 0 && valor <= saldo()) {
			this.valor = saldo() - valor;
			return true;
		}
		
		return false;
	}
	
	public boolean deposito(float valor) {
		if(valor >= 0) {
			this.valor = saldo() + valor;
			return true;
		}
		
		return false;
	}
	
	public float saldo() {
		return valor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return String.format("numeroAgencia: %s, numeroConta: %s, saldo: %s, dataAbertura: %s, cliente: %s",
				numeroAgencia, numeroConta, saldo(), dataAbertura, cliente);
	}
}
