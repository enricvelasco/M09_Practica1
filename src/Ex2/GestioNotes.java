package Ex2;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Classe amb el mètode principal. És l'encarregada d'invocar a la tasca, recollir el resultat i mostrar les dades de l'alumne.
 * Si el troba, és convenient que mostreu també el codi per veure que realment funciona.
 */
public class GestioNotes {

    public static void main(String[] args){
        Alumne alumneResposta;
        
        //Crear la lista de alumnos
        CreaAlumnes ca = new CreaAlumnes();
        ArrayList<Alumne> llistaAlumnat = ca.obtenirLlistat();
        for(Alumne item : llistaAlumnat){
            System.out.println("codi: "+item.codi+" - nota: "+item.notaF);
        }
        System.out.println("Llista creada");

        //pide la entrada de codigo
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese un codigo (sin espacios): ");
        int codigoIntroducido = entrada.nextInt();

        //distinngue la cantidad de alumnos
        if(llistaAlumnat.size() >= 10){
            //ejecuta el thread
            ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future resposta = executor.submit(new BuscaAlumne(codigoIntroducido, llistaAlumnat));
            while (!resposta.isDone()) {
                // Codigo ejecutable durante los Threads
            }
            try {
                alumneResposta = (Alumne) resposta.get();
                if(alumneResposta == null){
                    System.out.println("Alumne no trobat");
                }else{
                    System.out.println("Alumne Trobat: "+alumneResposta.codi + " nota: "+alumneResposta.notaF);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            executor.shutdown();
        }else{
            //Buscara de manera secuencial
            System.out.println("Busqueda secuencial");
            BuscaAlumne ba = new BuscaAlumne();
            alumneResposta = ba.buscarAlumnoEnLista(llistaAlumnat, codigoIntroducido);
            if(alumneResposta == null){
                System.out.println("Alumne no trobat");
            }else{
                System.out.println("Alumne Trobat: "+alumneResposta.codi + " nota: "+alumneResposta.notaF);
            }
        }

        entrada.close();

    }
}
