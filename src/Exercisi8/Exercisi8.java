package Exercisi8;

import java.util.concurrent.Semaphore;



class Exercisi8 extends Thread {
    private Exercisi8_comptador comptador;
    private Semaphore semaphore;

    public Exercisi8(Exercisi8_comptador comptador, Semaphore semaphore) {
        this.comptador = comptador;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire(); // Adquiere el semáforo

            int valorAnterior = comptador.getValor(); // Obtiene el valor actual del contador
            int nuevoValor = valorAnterior + 1; // Incrementa el valor en 1
            comptador.incrementar(); // Actualiza el contador

            System.out.println("Fil " + Thread.currentThread().getId() + ": el valor del comptador és " + nuevoValor);

            semaphore.release(); // Libera el semáforo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



