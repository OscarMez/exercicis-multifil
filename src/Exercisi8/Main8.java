package Exercisi8;

import java.util.concurrent.Semaphore;

public class Main8 {
    public static void main(String[] args) {
        int numSumadors = 5;  // Cambia esto por la cantidad deseada de hilos Sumador
        Exercisi8_comptador comptador = new Exercisi8_comptador();
        Semaphore semaphore = new Semaphore(1);

        Exercisi8[] sumadors = new Exercisi8[numSumadors];

        for (int i = 0; i < numSumadors; i++) {
            sumadors[i] = new Exercisi8(comptador, semaphore);
            sumadors[i].start();
        }

        try {
            for (int i = 0; i < numSumadors; i++) {
                sumadors[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado. Valor final del comptador: " + comptador.getValor());
    }
}
