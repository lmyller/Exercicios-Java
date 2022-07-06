package too.heranca.exercicio8;

import static too.heranca.gui.EntradaESaida.exibirMensagemDeErro;
import static too.heranca.gui.EntradaESaida.lerNumeroInteiro;
import static too.heranca.gui.EntradaESaida.lerString;
import static too.heranca.gui.EntradaESaida.menu;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import too.heranca.exercicio7.Cliente;
import too.heranca.exercicio7.ContaBancaria;
import too.heranca.exercicio7.ContaCorrente;
import too.heranca.exercicio7.ContaPoupanca;
import too.heranca.exercicio7.ContaRemunerada;

public class BancoVirtual {
	
	private static final String TITULO = "Banco virtual",
								ESCOLHA_OPCAO = "Escolha uma opção",
								ABRIR_CONTA = "Abrir conta",
								DEPOSITO = "Depósito",
								SALDO = "Saldo",
								TRANSFERENCIA = "Transferência",
								SAQUE = "Saque",
								RELATORIO = "Relatório",
								DIGITE_CPF = "CPF: ",
								CPF_INVALIDO = "CPF inválido!",
								DIGITE_NOME = "Nome ",
								DIGITE_SENHA = "Senha: ",
								DIGITE_SENHA_NOVAMENTE = "Confirmar senha: ",
								DIGITE_NUMERO_AGENCIA = "Numero da agência: ",
								SENHAS_DIFERENTES = "Senhas diferentes!",
								ESCOLHA_TIPO_CONTA = "Escolha tipo da conta",
								CONTA_CORRENTE = "Conta corrente",
								CONTA_POUPANCA = "Conta poupanca",
								CONTA_REMUNERADA = "Conta remunerada",
								SAIR = "Sair";
	
	private static final int COMANDO_ABRIR_CONTA = 0,
							 COMANDO_DEPOSITO = 1,
							 COMANDO_SALDO = 2,
							 COMANDO_TRANSFERENCIA = 3,
							 COMANDO_SAQUE = 4,
							 COMANDO_RELATORIO = 5,
							 COMANDO_SAIR = 6,
							 COMANDO_CONTA_CORRENTE = 0,
							 COMANDO_CONTA_POUPANCA = 1,
							 COMANDO_CONTA_REMUNERADA = 2,
							 TIPO_CONTA_CORRENTE = 1,
							 TIPO_CONTA_POUPANCA = 2,
							 TIPO_CONTA_REMUNERADA = 3;
	
	private static final float SALDO_INICIAL_CONTA_POUPANCA = 1.0f,
							   SALDO_INICIAL_CONTA_CORRENTE = 100.0f,
							   SALDO_INICIAL_CONTA_REMUNERADA = 300.0f;
										
	
	public static void main(String[] args) {
		new BancoVirtual();
		System.exit(0);
	}

	public BancoVirtual() {
		String[] opcoes = {ABRIR_CONTA, DEPOSITO, SALDO, TRANSFERENCIA, SAQUE, RELATORIO, SAIR};
		int opcao;
		ContasList contasList = ContasList.criarContasList();
		
		do {
			
			opcao = menu(ESCOLHA_OPCAO, TITULO, opcoes);
			
			if(opcao == JOptionPane.CLOSED_OPTION)
				break;
			
			switch (opcao) {
			case COMANDO_ABRIR_CONTA: abrirConta(contasList);
				
				break;

			default:
				break;
			}
			
		}while(opcao != COMANDO_SAIR);
	}

	private void abrirConta(ContasList contasList) {
		String cpf, nome, senha;
		int numeroAgencia, tipoContaBancaria;
		ContaBancaria contaBancaria;
		
		cpf = lerCpf();
		if(cpf == null)
			return;
		
		nome = lerNome();
		if(nome == null)
			return;
		
		senha = lerSenha();
		if(senha == null)
			return;
		
		numeroAgencia = lerNumeroInteiro(DIGITE_NUMERO_AGENCIA, TITULO);
		tipoContaBancaria = escolherTipoConta();
		
		if(tipoContaBancaria == JOptionPane.CLOSED_OPTION)
			return;
		
		contaBancaria = criarConta(cpf, nome, senha, numeroAgencia, tipoContaBancaria, contasList.quantidadeContas());
		contasList.adicionarContaBancaria(contaBancaria);
	}

	private String lerCpf() {
		String cpf;
		
		while(true) {
			cpf = lerString(DIGITE_CPF, TITULO);
			
			if(cpf == null)
				return null;
			
			if(Validacao.validarCPF(cpf)) 
				break;
			
			exibirMensagemDeErro(CPF_INVALIDO, TITULO);
		}
		
		return cpf;
	}
	
	private String lerNome() {
		String nome;
		
		while(true) {
			nome = lerString(DIGITE_NOME, TITULO);
			
			if(nome == null)
				return null;
			
			if(!nome.isBlank())
				break;
		}
		return nome;
	}
	
	private String lerSenha() {
		String senha, confirmarSenha;
		
		while(true) {
			senha = lerString(DIGITE_SENHA, TITULO);
			if(senha == null)
				return null;
			
			confirmarSenha = lerString(DIGITE_SENHA_NOVAMENTE, TITULO);
			if(confirmarSenha == null)
				return null;
			
			
			if(!senha.equals(confirmarSenha)) {
				exibirMensagemDeErro(SENHAS_DIFERENTES, TITULO);
				continue;
			}
			break;
		}
		return senha;
	}

	private ContaBancaria criarConta(String cpf, String nome, String senha, int numeroAgencia, int tipoContaBancaria, int quantidadeContas) {
		switch (tipoContaBancaria) {
		case COMANDO_CONTA_POUPANCA: return criarContaPoupanca(criarCliente(cpf, nome), senha, numeroAgencia, quantidadeContas);
		case COMANDO_CONTA_CORRENTE: return criarContaCorrente(criarCliente(cpf, nome), senha, numeroAgencia, quantidadeContas);
		case COMANDO_CONTA_REMUNERADA: return criarContaRemunerada(criarCliente(cpf, nome), senha, numeroAgencia, quantidadeContas);

		default: return null;
		}
	}

	private Cliente criarCliente(String cpf, String nome) {
		return null;
	}

	private ContaBancaria criarContaPoupanca(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaPoupanca(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_POUPANCA), senha, SALDO_INICIAL_CONTA_POUPANCA, 
								 obterDataAtual(), cliente);
	}
	
	private ContaBancaria criarContaCorrente(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaCorrente(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_POUPANCA), senha, SALDO_INICIAL_CONTA_CORRENTE,
								 obterDataAtual(), cliente);
	}
	
	private ContaBancaria criarContaRemunerada(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaRemunerada(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_POUPANCA), senha, SALDO_INICIAL_CONTA_REMUNERADA,
								   obterDataAtual(), cliente);
	}

	private String gerarNumeroConta(int quantidadeContas, String contaPoupanca) {
		switch (contaPoupanca) {
		case CONTA_POUPANCA: return String.format("%d-%04d", TIPO_CONTA_POUPANCA, quantidadeContas + 1);
		case CONTA_CORRENTE: return String.format("%d-%04d", TIPO_CONTA_CORRENTE, quantidadeContas + 1);
		case CONTA_REMUNERADA: return String.format("%d-%04d", TIPO_CONTA_REMUNERADA, quantidadeContas + 1);
		
		default: return null;
		}
	}

	private LocalDate obterDataAtual() {
		return LocalDate.now();
	}

	private int escolherTipoConta() {
		String[] opcoes = {CONTA_POUPANCA, CONTA_CORRENTE, CONTA_REMUNERADA};
		return menu(ESCOLHA_TIPO_CONTA, TITULO, opcoes);
	}
}
