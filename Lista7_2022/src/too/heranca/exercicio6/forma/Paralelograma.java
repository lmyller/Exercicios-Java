package too.heranca.exercicio6.forma;

public class Paralelograma extends Forma3D {
	public static final String PARALELOGRAMA = "Paralelograma",
							   BASE = "Base",
							   ALTURA = "Altura";
	
	private float base, altura;

	public Paralelograma() {
		super(PARALELOGRAMA);
	}

	public Paralelograma(String nome, String unidade) {
		super(nome, unidade);
	}

	public Paralelograma(String nome) {
		super(nome);
	}

	public Paralelograma(String nome, float base, float altura) {
		super(nome);
		
		this.base = base;
		this.altura = altura;
	}

	public Paralelograma(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public Paralelograma(String nome, String unidade, float base, float altura) {
		super(nome, unidade);
		
		this.base = base;
		this.altura = altura;
	}

	public final float getBase() {
		return base;
	}

	public final void setBase(float base) {
		this.base = base;
	}

	public final float getAltura() {
		return altura;
	}

	public final void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s, %s = %1.2f %s", super.toString(), PARALELOGRAMA, BASE, base, unidade, ALTURA, altura, unidade);
	}

	@Override
	public double area() {
		return base * altura;
	}	
}
