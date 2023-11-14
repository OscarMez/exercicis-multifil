package Exercisi2;

public class Exercisi2 extends Thread {
    // Valor comú compartit per tots els fils
    private static int[] compte = {1000}; // Inicialitzem amb 1000

    private String operacio; // 'suma' o 'resta'

    public Exercisi2(String operacio) {
        this.operacio = operacio;
    }

    public void run() {
        // Simula diverses operacions per il·lustrar la condició de carrera

            // Guarda el valor comú a un registre (atribut)
            int registre = compte[0];

            // Realitza l'operació (suma o resta)
            if (operacio.equals("suma")) {
                registre += 10;
            } else if (operacio.equals("resta")) {
                registre -= 10;
            }

            // Imprimeix el valor del registre
            System.out.println("Fil " + operacio + " => compte: " + compte[0]);



            // Imprimeix el valor actualitzat del compte
            System.out.println("Fil " + operacio + " => registre: " + registre + "\n");

            // Assigna el valor del registre al valor comú "compte"
            compte[0] = registre;

            System.out.println("Fil " + operacio + " => compte: " + compte[0]);
        }

    public static void main(String[] args) {
        // Crea dos fils, un per suma i un per resta
        Exercisi2 filSuma = new Exercisi2("suma");
        Exercisi2 filResta = new Exercisi2("resta");

        // Inicia els fils
        filSuma.start();
        filResta.start();

        // Espera fins que els fils hagin acabat
        try {
            filSuma.join();
            filResta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimeix el valor final de compte des del fil principal
        System.out.println("Fil principal: " + compte[0]);
    }
}
