package too.heranca.exercicio8;

import static too.heranca.gui.EntradaESaida.*;

import java.util.Arrays;

import javax.swing.JOptionPane;

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
								DIGITE_NOME = "Nome ",
								DIGITE_SENHA = "Senha: ",
								DIGITE_SENHA_NOVAMENTE = "Confirmar senha: ",
								DIGITE_NUMERO_AGENCIA = "Numero da agência: ",
								SENHAS_DIFERENTES = "Senhas diferentes!",
								SAIR = "Sair";
	
	private static final int COMANDO_ABRIR_CONTA = 0,
							 COMANDO_DEPOSITO = 1,
							 COMANDO_SALDO = 2,
							 COMANDO_TRANSFERENCIA = 3,
							 COMANDO_SAQUE = 4,
							 COMANDO_RELATORIO = 5,
							 COMANDO_SAIR = 6;
	
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
		String cpf, nome, senha, confirmarSenha;
		int numeroAgencia, tipoConta;
		
		while(true) {
			cpf = lerString(DIGITE_CPF, TITULO);
			
			if(cpf == null)
				return;
			
			if(Validacao.validarCPF(cpf)) 
				break;
		}
		nome = lerString(DIGITE_NOME, TITULO);
		
		while(true) {
			senha = lerString(DIGITE_SENHA, TITULO);
			if(senha == null)
				return;
			
			confirmarSenha = lerString(DIGITE_SENHA_NOVAMENTE, TITULO);
			if(confirmarSenha == null)
				return;
			
			if(!senha.equals(confirmarSenha)) {
				exibirMensagemDeErro(SENHAS_DIFERENTES, TITULO);
				continue;
			}
			break;
		}
		numeroAgencia = lerNumeroInteiro(DIGITE_NUMERO_AGENCIA, TITULO);
		
	}

	
}
