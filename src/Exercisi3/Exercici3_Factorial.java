package Exercisi3;

public class Exercici3_Factorial extends  Thread {

    private String nomdelFil;

    private int nombreFactorial;


    public Exercici3_Factorial(String nomdelFil, int nombreFactorial, int prioritat) {
        this.nomdelFil = nomdelFil;
        this.nombreFactorial = nombreFactorial;
        setPriority(prioritat);
    }


    private long calcularFibbonaci(int n) {
        if (n <= 1)
            return n;
        else
            return calcularFibbonaci(n - 1) + calcularFibbonaci(n - 2);
    }

    public void run() {
        long resultat = calcularFibbonaci(nombreFactorial);
        System.out.println(nomdelFil + "(" + getPriority() + ") : " + resultat);
    }
}
