package Ex3;

public class Caixa {

    private final int numCaixa;


    public Caixa(int id) {
        numCaixa = id;

    }

    public void passaACuaCaixa(int numCli) {
        System.out.println("pasa cua el client "+numCli+" caixa "+this.numCaixa);

    }

    public void passaAPagar() {
        System.out.println("pasa A PAGAR rn caja"+ this.numCaixa);

    }

    public void surt() {
        System.out.println("pasa A SALIR de caja"+ this.numCaixa);


    }



}