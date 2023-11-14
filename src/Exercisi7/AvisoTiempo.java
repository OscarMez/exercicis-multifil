package Exercisi7;

import java.util.concurrent.CountDownLatch;

public class AvisoTiempo extends Thread {
    private int tiempo;
    private CountDownLatch latch;

    public AvisoTiempo(int tiempo, CountDownLatch latch) {
        this.tiempo = tiempo;
        this.latch = latch;
    }

    @Override
    public void run() {
        double fraccion3 = 0.75;
        double fraccion2 = 0.5;
        double fraccion1 = 0.33;

        while (tiempo > 0) {
            if (tiempo == Math.ceil(fraccion3 * this.tiempo)) {
                System.out.println("Queda 75% del tiempo.");
            } else if (tiempo == Math.ceil(fraccion2 * this.tiempo)) {
                System.out.println("Queda 50% del tiempo.");
            } else if (tiempo == Math.ceil(fraccion1 * this.tiempo)) {
                System.out.println("Queda 33% del tiempo.");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempo--;
        }

        // Señala que el hilo ha terminado
        latch.countDown();
    }

}





