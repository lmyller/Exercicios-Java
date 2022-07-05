package too.heranca.gui;

import static javax.swing.JOptionPane.*;

public class EntradaESaida {

	public static int menu(String mensagem, String titulo, String[] opcoes) {
		return showOptionDialog(null, mensagem, titulo, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public static String lerString(String mensagem, String titulo) {
		return showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
	}

	public static int lerNumeroInteiro(String mensagem, String titulo) {
		while(true) {
			String string = lerString(mensagem, titulo);
			
			try {
				return Integer.parseInt(string);
			} catch (NumberFormatException e) {
				exibirMensagemDeErro(mensagem, titulo);
			}
		}
	}
	
	public static float lerNumeroReal(String mensagem, String titulo) {
		while(true) {
			String string = lerString(mensagem, titulo);
			
			try {
				return Float.parseFloat(string);
			} catch (NumberFormatException e) {
				exibirMensagemDeErro(mensagem, titulo);
			}
		}
	}
	
	public static void exibirMensagem(String mensagem, String titulo, int tipoMensagem) {
		showMessageDialog(null, mensagem, titulo, tipoMensagem);
	}
	
	public static void exibirMensagemInformativa(String mensagem, String titulo) {
		exibirMensagem(mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	public static void exibirMensagemDeErro(String mensagem, String titulo) {
		exibirMensagem(mensagem, titulo, ERROR_MESSAGE);
	}
}
