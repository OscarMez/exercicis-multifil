package Exercisi3;

public class Programa {

    public void Exercisi3(){
        System.out.println("Prova1");
        prova1();

        System.out.println("Prova2");
        prova2();
    }

    private  void prova1() {
        Exercici3_Factorial fil1 = new Exercici3_Factorial("Fil1", 30, Thread.MIN_PRIORITY);
        Exercici3_Factorial fil2 = new Exercici3_Factorial("Fil2", 30, Thread.MAX_PRIORITY);

        fil1.start();
        fil2.start();

        try {

            fil1.join();
            fil2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


    private  void prova2() {
        for (int i = 1; i <= 10; i++) {
            //para los primeros 5 se asignará minPriority y lo últimos 5 maxPriority
            int prioritat = (i <= 5) ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Exercici3_Factorial fil = new Exercici3_Factorial("Fil_ " + i, 30, prioritat);
            fil.start();
        }
    }
}
