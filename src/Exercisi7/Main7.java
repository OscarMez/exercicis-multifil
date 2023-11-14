package Exercisi7;

import java.util.concurrent.CountDownLatch;

public class Main7 {
    public static void main(String[] args) {
        int tiempoTotal = 10; // Puedes ajustar el tiempo total según tus necesidades
        CountDownLatch latch = new CountDownLatch(2);

        Exercisi7 contadorEnrere = new Exercisi7(tiempoTotal, latch);
        AvisoTiempo avisoTiempo = new AvisoTiempo(tiempoTotal, latch);

        contadorEnrere.start();
        avisoTiempo.start();

        // Espera hasta que ambos hilos hayan terminado su ejecución
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado");
    }
}



