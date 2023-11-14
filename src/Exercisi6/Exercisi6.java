package Exercisi6;

import java.util.Random;

public class Exercisi6 extends Thread {
    private int quantitatTotal;

    public Exercisi6(int quantitatTotal) {
        this.quantitatTotal = quantitatTotal;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < quantitatTotal; i++) {
            System.out.println("Fil 1: " + random.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



