package Exercisi7;

import java.util.concurrent.CountDownLatch;

public class Exercisi7 extends Thread {
    private int tiempo;
    private CountDownLatch latch;

    public Exercisi7(int tiempo, CountDownLatch latch) {
        this.tiempo = tiempo;
        this.latch = latch;
    }

    @Override
    public void run() {
        while (tiempo > 0) {
            System.out.println("Cuenta atrás: " + tiempo);
            tiempo--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Señala que el hilo ha terminado
        latch.countDown();
    }
}







