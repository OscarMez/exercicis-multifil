package Exercisi6;

public class Main6 {
    public static void main(String[] args) {
        Exercisi6 exercisi6 = new Exercisi6(5);
        Fil2 fil2 = new Fil2(exercisi6);

        exercisi6.start();
        fil2.start();

        // Espera hasta que ambos hilos hayan terminado su ejecución
        try {
            exercisi6.join();
            fil2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalitzat");
    }
}

