package Ex1;

import java.util.concurrent.Callable;

/**
 * Aquesta classe és la que calcularà el resultat del factorial i rebrà com a paràmetre del constructor el valor del número del
 * qual cal fer el càlcul. És convenient que utilitzeu un Double donat que el factorial creix molt ràpidament.
 *Si no sabeu com es fa aquest càlcul ho podeu trobar aquí:
 *http://ayudasprogramacionweb.blogspot.com.es/2013/01/calcular-factorial-de-un-numero-en-java.html
 */

public class Factorial implements Callable {

    private int n;

    public Factorial(int n) {
        this.n = n;
    }

    /**
     * Cuando se quiere un retorno se usa el call(), si fuera void usariamos run()
     * @return resultado de factorial(n)
     * @throws Exception
     */
    @Override
    public Double call() throws Exception{
        System.out.println("Thread: " + Thread.currentThread().getName()+ "COMIENZA A PROCESAR NUMERO: " + this.n);
        double resultado = factorial(this.n);
        return resultado;
    }

    /**
     *
     * @param n
     * @return el factorial de n
     */
    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
