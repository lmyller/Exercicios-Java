package too.heranca.exercicio6.forma;

/*
 * A classe Forma é a subclasse implícita da classe raiz de toda a hieraquia da API Java, ou seja, é  
 * subclasse direta da classe java.lang.Object.
 */
public class Forma {
	
	public double area() {
		return 0;
	}

	@Override
	public String toString() {
		return "Forma";
	}
} // class Forma