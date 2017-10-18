package Ex3;

import ejemploThreads.CajeraRunnable;
import ejemploThreads.Cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GestioSuper {
    public static void main(String[] args) {
        Supermercat s= new Supermercat(3);
        Client c[]= new Client [10];
        for (int i = 0; i < 10; i++) {
            c[i] = new Client(i+1,s);
            c[i].start();
        }


        /*Caixa caixesLlista = new Caixa()*/
        for (int i = 0; i < s.numCaixes; i++) {
            Caixa caixa = new Caixa(i);
            
        }

        /*ExecutorService executor = Executors.newFixedThreadPool(s.numCaixes);
        for (Client cliente: c) {
            Runnable client = new Supermercat(1);
            executor.execute(client);
        }

        executor.shutdown();	// Cierro el Executor
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos
            // para pasar a las siguientes instrucciones
        }*/
    }
}
