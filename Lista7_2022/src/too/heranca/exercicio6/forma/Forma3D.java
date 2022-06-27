package too.heranca.exercicio6.forma;

public class Forma3D extends FormaGeometrica {
	private Ponto ponto;

	public Forma3D() {
		// Chamada explícita ao construtor default da superclasse FormaGeometrica.
		super();
		ponto = Ponto.criarPonto(Ponto.NUMERO_COORDENADAS_3D);
	}

	public Forma3D(String nome) {
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
	
	public Forma3D(String nome, String unidade) {
		super(nome, unidade);
	}

	@Override
	public String toString() {
		return String.format("%s: Forma3D", super.toString());
	}

	/**
	 * Define a coordenada x de algum ponto da Forma3D.
	 */
	public void definirCoordenadaX(int x) {
		ponto.setX(x);
	}
	
	/**
	 * Define a coordenada y de algum ponto da Forma3D.
	 */
	public void definirCoordenadaY(int y) {
		ponto.setY(y);
	}
	
	/**
	 * Define a coordenada z de algum ponto da Forma3D.
	 */
	public void definirCoordenadaZ(int z) {
		ponto.setZ(z);
	}

	/**
	 * Obtém a coordenada x de algum ponto da Forma3D.
	 */
	public int obterCoordenadaX() {
		return ponto.getX();
	}

	/**
	 * Obtém a coordenada y de algum ponto da Forma3D.
	 */
	public int obterCoordenadaY() {
		return ponto.getY();
	}
	
	/**
	 * Obtém a coordenada z de algum ponto da Forma3D.
	 */
	public int obterCoordenadaZ() {
		return ponto.getZ();
	}
} // class Forma3D 
