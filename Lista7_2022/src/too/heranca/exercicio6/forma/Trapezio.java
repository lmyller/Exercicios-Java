package too.heranca.exercicio6.forma;

public class Trapezio extends Forma3D {
	public static final String TRAPEZIO = "Trapézio",
			   				   BASE_MAIOR = "Base maior",
			   				   BASE_MENOR = "Base menor",
			   				   ALTURA = "Altura";
	
	private float baseMaior, baseMenor, altura;
	
	public Trapezio() {
		super(TRAPEZIO);
	}

	public Trapezio(String nome, String unidade) {
		super(nome, unidade);
	}

	public Trapezio(String nome) {
		super(nome);
	}

	public Trapezio(String nome, float baseMaior, float baseMenor, float altura) {
		super(nome);
		
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
	}

	public Trapezio(float baseMaior, float baseMenor, float altura) {
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
	}
	
	public Trapezio(String nome, String unidade, float baseMaior, float baseMenor, float altura) {
		super(nome, unidade);
		
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
	}

	public final float getBaseMaior() {
		return baseMaior;
	}

	public final void setBaseMaior(float baseMaior) {
		this.baseMaior = baseMaior;
	}

	public final float getBaseMenor() {
		return baseMenor;
	}

	public final void setBaseMenor(float baseMenor) {
		this.baseMenor = baseMenor;
	}

	public final float getAltura() {
		return altura;
	}

	public final void setAltura(float altura) {
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s, %s = %1.2f %s, %s = %1.2f", super.toString(), TRAPEZIO, BASE_MAIOR, baseMaior, unidade, 
							  BASE_MENOR, baseMenor, unidade, ALTURA, altura, unidade);
	}

	@Override
	public double area() {
		return baseMaior + baseMenor / 2 * altura;
	}
}
