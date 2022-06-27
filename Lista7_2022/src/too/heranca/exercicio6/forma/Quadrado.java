package too.heranca.exercicio6.forma;

public class Quadrado extends Forma2D {
	public static final String QUADRADO = "Quadrado", LADO = "lado";
	private float lado;
	
	// Este ponto será usado para desenhar o quadrado na interface gráfica. 
	//private Ponto cantoSuperiorEsquerdo;

	public Quadrado() {
		// Chamada explícita ao construtor sobrecarregado da superclasse Forma2D.
		super(QUADRADO);
	}

	public Quadrado(String nome) {
		super(nome);
	}

	public Quadrado(float lado) {
		super(QUADRADO);
		this.lado = lado;
	}

	public Quadrado(float lado, String unidade) {
		super(QUADRADO);
		
		this.unidade = unidade; // O atributo unidade tem acesso protegido.
		this.lado = lado;
	}

	public float getLado() {
		return lado;
	}

	public void setLado(float lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s", super.toString(), QUADRADO, LADO, lado, unidade);
	}

	@Override
	public double area() {
		return lado * lado;
	}
} // class Quadrado