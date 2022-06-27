package too.heranca.exercicio6.forma;

public class FormaGeometrica extends Forma {
	public static final String 
		CENTIMETRO = "cm",
		CENTIMETRO_QUADRADO = "cm²",
		METRO = "m",
		METRO_QUADRADO = "m²";
	
	// Membros protegidos podem ser acessados diretamente por todas as subclasses e classes do mesmo pacote.
	protected String nome, unidade;

	/**
	 * Inicia a forma geométria com a unidade padrão FormaGeometrica.CENTIMETRO.
	 */
	public FormaGeometrica() {
		// Chamada explícita ao construtor default da superclasse Forma.
		super();
		unidade = CENTIMETRO;
	}

	/**
	 * Inicia a forma geométria com a unidade padrão FormaGeometrica.CENTIMETRO.
	 */
	public FormaGeometrica(String nome) {
		// Chamada implícita ao construtor default da superclasse Forma.
		this.nome = nome;
		unidade = CENTIMETRO;
	}

	public FormaGeometrica(String nome, String unidade) {
		this.nome = nome;
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	/**
	 * Define a unidade métrica usada para representar as dimensões das formas geométricas.
	 * 
	 * @param unidade os valores válidos para unidade são as contantes CENTIMETRO, CENTIMETRO_QUADRADO, 
	 *  METRO, METRO_QUADRADO definidas na classe FormaGeometrica.
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		// Chamada ao método toString da superclasse Forma.
		return String.format("%s: FormaGeometrica", super.toString());
	}
} // class FormaGeometrica