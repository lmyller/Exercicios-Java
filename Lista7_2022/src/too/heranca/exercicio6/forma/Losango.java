package too.heranca.exercicio6.forma;

public class Losango extends Forma3D {
	public static final String LOSANGO = "Losango",
			   				   DIAGONAL_MAIOR = "Diagonal maior",
			   				   DIAGONAL_MENOR = "Diagonal menor";
	
	private float diagonalMaior, diagonalMenor;
	
	public Losango() {
		super(LOSANGO);
	}

	public Losango(String nome, String unidade) {
		super(nome, unidade);
	}

	public Losango(String nome) {
		super(nome);
	}

	public Losango(String nome, float diagonalMaior, float diagonalMenor) {
		super(nome);
		
		this.diagonalMaior = diagonalMaior;
		this.diagonalMenor = diagonalMenor;
	}

	public Losango(float diagonalMaior, float diagonalMenor) {
		this.diagonalMaior = diagonalMaior;
		this.diagonalMenor = diagonalMenor;
	}
	
	public Losango(String nome, String unidade, float diagonalMaior, float diagonalMenor) {
		super(nome, unidade);
		
		this.diagonalMaior = diagonalMaior;
		this.diagonalMenor = diagonalMenor;
	}

	public final float getDiagonalMaior() {
		return diagonalMaior;
	}

	public final void setDiagonalMaior(float diagonalMaior) {
		this.diagonalMaior = diagonalMaior;
	}

	public final float getDiagonalMenor() {
		return diagonalMenor;
	}

	public final void setDiagonalMenor(float diagonalMenor) {
		this.diagonalMenor = diagonalMenor;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s - %s = %1.2f %s, %s = %1.2f %s", super.toString(), LOSANGO, DIAGONAL_MAIOR, diagonalMaior, unidade, 
							  DIAGONAL_MENOR, diagonalMenor, unidade);
	}

	@Override
	public double area() {
		return diagonalMaior * diagonalMenor / 2;
	}
}
