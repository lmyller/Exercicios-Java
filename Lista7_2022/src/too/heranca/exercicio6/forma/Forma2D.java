package too.heranca.exercicio6.forma;

public class Forma2D extends FormaGeometrica {
	/* O relacionamento de todo objeto Forma2D com o objeto Ponto é de composição, também chamado de
	 * relacionamento "tem-um". No entanto, por ser de composição o objeto Ponto não será compartilhado
	 * pela classe Forma2D. 
	 */
	private Ponto ponto;

	public Forma2D() {
		// Chamada explícita ao construtor default da superclasse FormaGeometrica.
		super();
		ponto = Ponto.criarPonto(Ponto.NUMERO_COORDENADAS_2D);
	}

	public Forma2D(String nome) {
		// Chamada implícita ao construtor default da superclasse FormaGeometrica.
		this();
		
		/* Como o nome é definido na superclasse FormaGeometrica com acesso protegido é possível 
		 * acessá-lo diretamente em todas as subclasses dessa classe.
		 */
		this.nome = nome;

		/* O método abaixo tem a vantagem de usar o aproveitamento de código por meio da herança e de
		 * executar o que foi codificado por ele, por exemplo, validando o número de caracteres do nome.
		 * 
		 *  setNome(nome);  
		 */
	}
	
	public Forma2D(String nome, String unidade) {
		super(nome, unidade);
	}

	@Override
	public String toString() {
		return String.format("%s: Forma2D", super.toString());
	}

	/**
	 * Define a coordenada x de algum ponto da Forma2D.
	 */
	public void definirCoordenadaX(int x) {
		ponto.setX(x);
	}
	
	/**
	 * Define a coordenada y de algum ponto da Forma2D.
	 */
	public void definirCoordenadaY(int y) {
		ponto.setY(y);
	}
	
	/**
	 * Obtém a coordenada x de algum ponto da Forma2D.
	 */
	public int obterCoordenadaX() {
		return ponto.getX();
	}

	/**
	 * Obtém a coordenada y de algum ponto da Forma2D.
	 */
	public int obterCoordenadaY() {
		return ponto.getY();
	}
} // class Forma2D