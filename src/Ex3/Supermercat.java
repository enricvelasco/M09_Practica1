package Ex3;

import java.util.ArrayList;

public class Supermercat {
    Caixa[] caixes;
    //ArrayList<Caixa> caixas;
    int numCaixes;


    public Supermercat(int numCaixes) {
        this.numCaixes = numCaixes;
        caixes = new Caixa[numCaixes];
        for (int i = 0; i < numCaixes; i++) {
            Caixa caixa = new Caixa(i + 1);
            caixes[i] = caixa;

        }
    }

    public void arribaClient(int numCli) {
        System.out.println("Entra al super el client " + numCli);
    }

    public void passaACuaCaixa(int numCli, int numCaixa) {
        caixes[numCaixa].passaACuaCaixa(numCli);
        //System.out.println("Pasa a cola de caja "+ numCaixa + " el client " + numCli);

    }

    public void passaAPagar(int numCaixa) {
        caixes[numCaixa].passaAPagar();
        //System.out.println("cobra caja "+ numCaixa);
    }

    public void surt(int numCaixa) {
        caixes[numCaixa].surt();
        //System.out.println("finaliza caja "+ numCaixa);
    }
}
