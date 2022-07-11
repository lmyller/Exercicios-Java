package too.heranca.exercicio8;

import static too.heranca.gui.EntradaESaida.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
								DIGITE_NOME = "Nome:",
								DIGITE_SENHA = "Senha:",
								DIGITE_SENHA_NOVAMENTE = "Confirmar senha:",
								DIGITE_NUMERO_AGENCIA = "Número da agência:",
								DIGITE_NUMERO_AGENCIA_ORIGEM = "Número da agência de origem:",
								DIGITE_NUMERO_AGENCIA_DESTINO = "Número da agência de destino:",
								DIGITE_NUMERO_CONTA = "Número da conta: ",
								DIGITE_NUMERO_CONTA_ORIGEM = "Número da conta de origem: ",
								DIGITE_NUMERO_CONTA_DESTINO = "Número da conta de destino: ",
								SENHAS_DIFERENTES = "Senhas diferentes!",
								ESCOLHA_TIPO_CONTA = "Escolha tipo da conta",
								CONTA_CORRENTE = "Conta corrente",
								CONTA_POUPANCA = "Conta poupanca",
								CONTA_REMUNERADA = "Conta remunerada",
								CONTA_NAO_ENCONTRADA = "Conta não encontrada!",
								DEPOSITO_REALIZADO = "Depósito realizado com sucesso!",
								SAQUE_REALIZADO = "Saque realizado com sucesso!",
								TRANSFERENCIA_REALIZADO = "Transferência realizada com sucesso!",
								ERRO_DEPOSITO = "Erro ao realizar o depósito!",
								ERRO_SAQUE = "Erro ao realizar o saque!",
								ERRO_TRANSFERENCIA = "Erro ao realizar a transferência!",
								OPERACAO_CANCELADA = "Operação cancelada!",
								SENHA_INVÁLIDA = "Senha Inválida!",
								TENTATIVAS_ESGOTADAS = "Tentativas esgotadas!", 
								DIGITE_VALOR_DEPOSITO = "Valor de depósito:",
								DIGITE_VALOR_SAQUE = "Valor de saque:",
								DIGITE_VALOR_TRANSFERENCIA = "Valor de transferência:",
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
			case COMANDO_ABRIR_CONTA: abrirConta(contasList); break;
			case COMANDO_DEPOSITO: deposito(contasList); break;
			case COMANDO_SAQUE: saque(contasList); break;
			case COMANDO_TRANSFERENCIA: transferencia(contasList); break;
			case COMANDO_RELATORIO: relatorio(contasList); break;
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
	
	private void deposito(ContasList contasList) {
		ContaBancaria contaBancaria;
		String numeroAgencia = lerString(DIGITE_NUMERO_AGENCIA, TITULO),
			   numeroConta = lerString(DIGITE_NUMERO_CONTA, TITULO);
		
		if(numeroAgencia == null || numeroConta == null)
			return;
		
		contaBancaria = pesquisarConta(contasList, numeroAgencia, numeroConta);
		if(contaBancaria == null)
			exibirMensagemDeErro(CONTA_NAO_ENCONTRADA, TITULO);
		
		else {
			float valor = lerNumeroReal(DIGITE_VALOR_DEPOSITO, TITULO);
			if(contaBancaria.deposito(valor))
				exibirMensagemInformativa(DEPOSITO_REALIZADO, TITULO);
			
			else {
				exibirMensagemDeErro(ERRO_DEPOSITO, TITULO);
				exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
			}
		}
	}
	
	private void saque(ContasList contasList) {
		ContaBancaria contaBancaria;
		String numeroAgencia = lerString(DIGITE_NUMERO_AGENCIA, TITULO),
			   numeroConta = lerString(DIGITE_NUMERO_CONTA, TITULO);
		
		if(numeroAgencia == null || numeroConta == null)
			return;
		
		contaBancaria = pesquisarConta(contasList, numeroAgencia, numeroConta);
		if(contaBancaria == null)
			exibirMensagemDeErro(CONTA_NAO_ENCONTRADA, TITULO);
		
		else {
			if(!verificarSenha(contaBancaria.getSenha()))
				return;
			
			float valor = lerNumeroReal(DIGITE_VALOR_SAQUE, TITULO);
			if(contaBancaria.saque(valor))
				exibirMensagemInformativa(SAQUE_REALIZADO, TITULO);
			
			else {
				exibirMensagemDeErro(ERRO_SAQUE, TITULO);
				exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
			}
		}
	}

	private void transferencia(ContasList contasList) {
		ContaBancaria contaBancariaOrigem, contaBancariaDestino;
		String numeroAgencia = lerString(DIGITE_NUMERO_AGENCIA_ORIGEM, TITULO),
			   numeroConta = lerString(DIGITE_NUMERO_CONTA_ORIGEM, TITULO);
		
		if(numeroAgencia == null || numeroConta == null)
			return;
		
		contaBancariaOrigem = pesquisarConta(contasList, numeroAgencia, numeroConta);
		if(contaBancariaOrigem == null)
			exibirMensagemDeErro(CONTA_NAO_ENCONTRADA, TITULO);
		
		else {
			if(!verificarSenha(contaBancariaOrigem.getSenha()))
				return;
			
			float valor = lerNumeroReal(DIGITE_VALOR_TRANSFERENCIA, TITULO);
			if(contaBancariaOrigem.saque(valor)) {
				numeroAgencia = lerString(DIGITE_NUMERO_AGENCIA_DESTINO, TITULO);
				numeroConta = lerString(DIGITE_NUMERO_CONTA_DESTINO, TITULO);
				
				contaBancariaDestino = pesquisarConta(contasList, numeroAgencia, numeroConta);
				if(contaBancariaDestino == null) {
					exibirMensagemDeErro(CONTA_NAO_ENCONTRADA, TITULO);
					exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
					contaBancariaOrigem.deposito(valor);
				}
				
				else {
					if(contaBancariaDestino.deposito(valor)) 
						exibirMensagemInformativa(TRANSFERENCIA_REALIZADO, TITULO);
					
					else {
						exibirMensagemDeErro(ERRO_TRANSFERENCIA, TITULO);
						exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
					}
				}
			}
			
			else {
				exibirMensagemDeErro(ERRO_SAQUE, TITULO);
				exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
			}
		}
	}
	
	private boolean verificarSenha(String senha) {
		int tentativa = 0;
				
		while(true) {
			if(senha.equals(lerString(DIGITE_SENHA, TITULO)))
				return true;
			
			else
				exibirMensagemDeErro(SENHA_INVÁLIDA, TITULO);
			
			tentativa++;
			if(tentativa == 3) {
				exibirMensagemDeErro(TENTATIVAS_ESGOTADAS, TITULO);
				exibirMensagemDeErro(OPERACAO_CANCELADA, TITULO);
				break;
			}
		}
		return false;
	}
	
	private ContaBancaria pesquisarConta(ContasList contasList, String numeroAgencia, String numeroConta) {
		ContaBancaria contaBancaria;
		
		for(int indice = 0; indice < contasList.quantidadeContas(); indice++) {
			contaBancaria = contasList.obterContaBancaria(indice);
			if(contaBancaria.getNumeroConta().equals(numeroConta) && contaBancaria.getNumeroAgencia() == Integer.parseInt(numeroAgencia))
				return contaBancaria;
		}
		return null;
	}
	
	private void relatorio(ContasList contasList) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(obterDataAtual()).append("\n");
		stringBuilder.append(obterHoraAtual()).append("\n");
		
		for(int indice = 0; indice < contasList.quantidadeContas(); indice++) {
			ContaBancaria conta = contasList.obterContaBancaria(indice);
			
			stringBuilder.append(String.format("\n%s. %s\t%s\tR$ %,1.2f\t%s", conta.getNumeroConta(), conta.getCliente().getNome(),
												conta.getCliente().getCpf(), conta.saldo(), conta.getDataAbertura()));
		}
		exibirCaixaDeTexto(stringBuilder.toString(), TITULO, contasList.quantidadeContas() + 5, 50);
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
		return new Cliente(nome, cpf);
	}

	private ContaBancaria criarContaPoupanca(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaPoupanca(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_POUPANCA), senha, SALDO_INICIAL_CONTA_POUPANCA, 
								 obterDataAtual(), cliente);
	}
	
	private ContaBancaria criarContaCorrente(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaCorrente(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_CORRENTE), senha, SALDO_INICIAL_CONTA_CORRENTE,
								 obterDataAtual(), cliente);
	}
	
	private ContaBancaria criarContaRemunerada(Cliente cliente, String senha, int numeroAgencia, int quantidadeContas) {
		return new ContaRemunerada(numeroAgencia, gerarNumeroConta(quantidadeContas, CONTA_REMUNERADA), senha, SALDO_INICIAL_CONTA_REMUNERADA,
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
	
	private String obterHoraAtual() {
		return new SimpleDateFormat("HH:ss").format(new Date());
	}


	private String obterDataAtual() {
		return DateFormat.getDateInstance(DateFormat.SHORT).format(new Date());
	}

	private int escolherTipoConta() {
		String[] opcoes = {CONTA_POUPANCA, CONTA_CORRENTE, CONTA_REMUNERADA};
		return menu(ESCOLHA_TIPO_CONTA, TITULO, opcoes);
	}
}
