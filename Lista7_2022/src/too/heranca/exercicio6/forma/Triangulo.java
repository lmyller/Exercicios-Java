package too.heranca.exercicio6.forma;

public class Triangulo extends Forma2D {
	public static final String TRIANGULO = "Triângulo", BASE = "base", ALTURA = "altura";
	private float base, altura;
	
	public Triangulo() {
		super(TRIANGULO);
	}
	
	public Triangulo(String nome) {
		super(nome);
	}
	
	public Triangulo(float base, float altura) {
		super(TRIANGULO);
		this.base = base;
		this.altura = altura;
	}
	
	public Triangulo(String unidade, float base, float altura) {
		super(TRIANGULO);
		
		this.unidade = unidade; // O atributo unidade tem acesso protegido.
		this.base = base;
		this.altura = altura;
	}
	
	public float getBase() {
		return base;
	}
	
	public void setBase(float base) {
		this.base = base;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s ; %s = %1.2f %s", super.toString(), TRIANGULO, BASE, base, unidade,
				                               ALTURA, altura, unidade);
	}

	@Override
	public double area() {
		return base * altura / 2;
	}
} // class Triangulo 