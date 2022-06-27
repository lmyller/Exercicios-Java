package too.heranca.exercicio6.forma;

public class Circulo extends Forma2D {
	public static final String CIRCULO = "Circulo", RAIO = "raio";
	private float raio;

	// Este ponto será usado para desenhar o círculo na interface gráfica. 
	//private Ponto cantoSuperiorEsquerdoQuadradoEnvolveCirculo;

	public Circulo() {
		// Chamada explícita ao construtor sobrecarregado da superclasse Forma2D.
		super(CIRCULO);
	}
	
	public Circulo(String nome) {
		super(nome);
	}
	
	public Circulo(float raio) {
		super(CIRCULO);
		this.raio = raio;
	}

	public Circulo(String unidade, float raio) {
		super(CIRCULO);
		
		setUnidade(unidade);
		this.raio = raio;
	}

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}

	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s", super.toString(), CIRCULO, RAIO, raio, unidade);
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
} // class Circulo 