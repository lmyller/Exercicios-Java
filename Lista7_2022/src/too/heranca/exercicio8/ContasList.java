package too.heranca.exercicio8;

import java.util.ArrayList;
import java.util.List;

import too.heranca.exercicio7.ContaBancaria;

public class ContasList {
	List<ContaBancaria> contaBancariasList;

	private ContasList() {
		contaBancariasList = new ArrayList<>();
	}
	
	public void adicionarContaBancaria(ContaBancaria contaBancaria) {
		contaBancariasList.add(contaBancaria);
	}
	
	public ContaBancaria obterContaBancaria(int posicao) {
		return contaBancariasList.get(posicao);
	}
	
	public int quantidadeContas() {
		return contaBancariasList.size();
	}
	
	public static ContasList criarContasList() {
		return new ContasList();
	}
}
