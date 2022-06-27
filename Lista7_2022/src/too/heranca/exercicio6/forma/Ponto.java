package too.heranca.exercicio6.forma;

/**
 * Representa a localização do ponto com duas (x,y) ou três (x,y,z) coordenadas.
 */
public class Ponto {
	/**
	 * Número de coordenadas de um ponto em duas dimensões (x,y). 
	 */
	public static final byte NUMERO_COORDENADAS_2D  = 2;  
	
	/**
	 * Número de coordenadas de um ponto em três dimensões (x,y,z).
	 */
	public static final byte NUMERO_COORDENADAS_3D = 3;
	
	private String nome;
	private int[] coordenadas;

	// Este construtor por ser privado não é visível fora da classe, portanto não pode ser usado para criar um ponto.
	private Ponto(int numeroCoordenadas) {
		coordenadas = new int[numeroCoordenadas];
		nome = "Ponto";
	}

	public Ponto(int x, int y) {
		this(NUMERO_COORDENADAS_2D);
		coordenadas[0] = x;
		coordenadas[1] = y;
	}

	public Ponto(int x, int y, int z) {
		this(NUMERO_COORDENADAS_3D);
		coordenadas[0] = x;
		coordenadas[1] = y;
		coordenadas[2] = z;
	}
	
	public Ponto(String nome, int x, int y) {
		this(x, y);
		this.nome = nome;
	}

	public Ponto(String nome, int x, int y, int z) {
		this(x, y, z);
		this.nome = nome;
	}

	/**
	 * Cria um ponto com duas (x,y) ou três (x,y,z) coordenadas.
	 * 
	 * @param numeroCoordenadas o número de coordenadas válido é definido pelas constantes 
	 * 				 NUMERO_COORDENADAS_2D e NUMERO_COORDENADAS_3D.
	 * 
	 * @return o objeto Ponto com duas (x,y) ou três (x,y,z) coordenadas.
	 */
	public static Ponto criarPonto(int numeroCoordenadas) {
		return new Ponto(numeroCoordenadas);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX() {
		return coordenadas[0];
	}

	public void setX(int x) {
		coordenadas[0] = x;
	}

	public int getY() {
		return coordenadas[1];
	}

	public void setY(int y) {
		coordenadas[1] = y;
	}

	/**
	 * Se o ponto não possui três coordenadas, é um ponto de duas dimensões, será retornado zero.
	 */
	public int getZ() {
		return (coordenadas.length == NUMERO_COORDENADAS_3D) ? coordenadas[NUMERO_COORDENADAS_2D] : 0;
	}

	/**
	 * Se o ponto não possui três coordenadas, é um ponto de duas dimensões, nenhuma coordenada será modificada.
	 */
	public void setZ(int z) {
		if (coordenadas.length == NUMERO_COORDENADAS_3D)
			coordenadas[NUMERO_COORDENADAS_2D] = z;
	}
	
	@Override
	public String toString() {
		StringBuilder pontoBuilder = new StringBuilder(nome + "(");
		
		for (int indice = 0; indice < coordenadas.length; indice++) {
			pontoBuilder.append(coordenadas[indice]);
			
			if (indice < coordenadas.length - 1)
				pontoBuilder.append(", ");
		}
		pontoBuilder.append(")");
		
		return pontoBuilder.toString();
	}
} // class Ponto