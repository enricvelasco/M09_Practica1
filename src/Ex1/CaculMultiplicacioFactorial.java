package Ex1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Volem calcular quin seria el resultat de multiplicar 1000 vegades el factorial d'un determinat número.
 * En comptes de fer-ho de la forma més natural (multiplicant 1000 vegades el resultat d'aquest factorial),
 * calculareu 1000 vegades aquest resultat i després fareu la suma.
 * Per a fer-ho creareu un pool de mida fixa que tindrà tants fils com processadors disposeu (Runtime.getRuntime().availableProcessors()).
 */

/**
 * Aquesta classe serà la que contindrà el programa multifil i per tant serà l'encarregada de fer les instanciacions i les crides,
 * recollir els resultats, fer la suma i mostrar la suma final.
 * Podeu posar directament per codi el valor del qual voleu calcular el factorial.
 */

public class CaculMultiplicacioFactorial {
    public static void main(String[] args) {
        double sum = 0;

        //Servicio de ejecucion de Threads, crea los Theads a partir de los procesadores del equipo
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i=0; i<1000; i++) {
            Future future = executor.submit(new Factorial(5));
            while (!future.isDone()) {
                // Codigo ejecutable durante los Threads
            }
            try {
                //respuesta de cada thread
                sum += (double)future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                //Este método interrumpe todos los hilos que están en ejecución.
                executor.shutdownNow();
            } catch (ExecutionException e) {
                e.printStackTrace();
                //Este método interrumpe todos los hilos que están en ejecución.
                executor.shutdownNow();
            }
        }
        System.out.println("Resultado: "+ sum);
        //Este método indica al executor que no acepte más tareas, si hay cola deja que terminen (no interrumpe)
        executor.shutdown();
    }
}
