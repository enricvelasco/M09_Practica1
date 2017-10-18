package Ex2;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * És l'encarregada de trobar l'alumne. Aquesta tasca ens ha de retornar un Alumne en el cas que aquest existeixi a la
 * llista o null en cas contrari. Donat el gran nombre d'alumnes, aquesta tasca es dividirà en subtasques i només
 * s'intentarà trobar-lo seqüencialment quan el nombre d'alumnes no sigui més gran de 10.
 * És aconsellable que no continuï buscant una vegada hagi trobat l'alumne.
 */
public class BuscaAlumne implements Callable {
    private int codiAlumne;
    private ArrayList<Alumne> llistaAlumnes;

    public BuscaAlumne(int codiAlumne, ArrayList<Alumne> llistaAlumnes) {
        this.codiAlumne = codiAlumne;
        this.llistaAlumnes = llistaAlumnes;
    }

    public BuscaAlumne() {
    }

    @Override
    public Alumne call() throws Exception {
        System.out.println("Thread: " + Thread.currentThread().getName()+ "COMIENZA A Alumno: " + this.codiAlumne);
        Alumne respostaCall = buscarAlumnoEnLista(this.llistaAlumnes, this.codiAlumne);
        return respostaCall;
    }

    Alumne buscarAlumnoEnLista(ArrayList<Alumne> lista, int codiAlumne) {
        Alumne retornAlumneTrobat = null;
        for(Alumne alumne : lista){
            if(alumne.codi == codiAlumne){
                retornAlumneTrobat = alumne;
                break;
            }
        }
        return retornAlumneTrobat;
    }
}
