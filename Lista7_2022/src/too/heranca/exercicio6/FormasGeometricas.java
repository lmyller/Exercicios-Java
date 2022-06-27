package too.heranca.exercicio6;

import too.heranca.exercicio6.forma.Circulo;
import too.heranca.exercicio6.forma.Forma;
import too.heranca.exercicio6.forma.Forma2D;
import too.heranca.exercicio6.forma.Forma3D;
import too.heranca.exercicio6.forma.FormaGeometrica;
import too.heranca.exercicio6.forma.Quadrado;
import too.heranca.exercicio6.forma.Triangulo;

public class FormasGeometricas {

	public static void main(String[] args) {
		formasGeometricas();
	}

	public static void formasGeometricas() {
		Forma forma = new Forma();
		Forma2D forma2D = new Forma2D();
		Forma3D forma3D = new Forma3D();
		Quadrado quadrado = new Quadrado(8, FormaGeometrica.CENTIMETRO);
		Circulo circulo = new Circulo(5);
		Triangulo triangulo = new Triangulo(16, 32);

		// Vetor de objetos da superclasse FormaGeometrica.
		FormaGeometrica formasGeometricas[] = { new Quadrado(4), new Circulo(2), new Triangulo(8, 16) };

		// Exibe os atributos dos objetos usando a referência do objeto.
		System.out.println(forma);
		System.out.println(forma2D);
		System.out.println(forma3D);
		System.out.println(quadrado);
		System.out.println(circulo);
		System.out.println(triangulo);
		
		// Define as dimensões do quadrado, círculo e triângulo.
		System.out.println();
		quadrado.setLado(18);
		circulo.setRaio(15);
		triangulo.setAltura(30);
		triangulo.setBase(15);

		/*
		 * // ERRO: não permite acessar um atributo protegido em um pacote diferente de definição da classe.
		 * forma2D.nome = "";  
		 * 
		 * // ERRO: não é permitido acessar um método público definido na subclasse usando a referência da superclasse.
		 * forma.setLado(8);     
		 */
		
		// Exibe os atributos dos objetos usando a referência do objeto.
		System.out.println(quadrado);
		System.out.println(circulo);
		System.out.println(triangulo);
		
		System.out.printf("\nÁrea do %s = %1.2f cm²\n", quadrado.getNome(), quadrado.area());
		System.out.printf("Área do %s = %1.2f cm²\n\n", circulo.getNome(), circulo.area());

		// Exibe os atributos de um objeto de subclasse usando a referência da superclasse, porque todo objeto de subclasse é um objeto da superclasse.
		forma = quadrado;
		System.out.printf("Quadrado exibido via referência da superclasse Forma:\n\t\t%s\n", forma.toString());

		// Verifica se o tipo de dado do objeto acessado via a referência forma é do tipo Quadrado.   
		if (forma instanceof Quadrado) {
			// Um objeto de superclasse não é um objeto de subclasse, por isso o uso do downcast (coerção de um supertipo para um subtipo).
			Quadrado quadradoMagico = (Quadrado) forma;
			System.out.printf("\nQuadrado exibido via referência da subclasse Quadrado:\n\t\t%s\n", quadradoMagico);
		}
		else
			System.out.println("\nO tipo do objeto referenciado por forma não é um Quadrado.");

		// Verifica se o tipo de dado do objeto acessado via a referência forma é do tipo Circulo.
		if (forma instanceof Circulo) {
			// Um objeto de superclasse não é um objeto de subclasse, por isso o uso do downcast (coerção de um supertipo para um subtipo).
			circulo = (Circulo) forma;
			System.out.printf("\nCirculo exibido via referência da subclasse Circulo:\n\t\t%s\n", circulo);
		}
		else
			System.out.printf("\nO tipo do objeto referenciado por forma não é um Circulo. É um %s.\n", forma.getClass().getSimpleName());

		// Exibe os atributos de um objeto de subclasse usando a referência da superclasse, porque todo objeto de subclasse é um objeto da superclasse.
		forma = circulo;
		System.out.printf("\nCirculo exibido via referência da superclasse Forma:\n\t\t%s\n", forma.toString());

		// Exibe os atributos dos objetos de subclasse usando a referência da superclasse FormaGeometrica.
		for (FormaGeometrica formaGeometrica : formasGeometricas)
			System.out.printf("\nÁrea do %s = %1.2f cm²", formaGeometrica.getNome(), formaGeometrica.area());
	} // formasGeometricas()
} // class FormasGeometricas