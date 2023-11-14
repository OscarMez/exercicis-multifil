package Exercisi6;

import java.util.Random;

public class Fil2 extends Thread {
    private Exercisi6 exercisi6;

    public Fil2(Exercisi6 exercisi6) {
        this.exercisi6 = exercisi6;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (exercisi6.isAlive()) {
            System.out.println("Fil 2: " + random.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
