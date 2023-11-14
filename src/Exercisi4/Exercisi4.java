package Exercisi4;

import java.util.Scanner;

public class Exercisi4 extends Thread{

    private static  int numeroFibonnaci;

    public  void exercisi4() {
        Scanner escaner = new Scanner(System.in);
        boolean numeroValido = false;
        do {
            try {
                System.out.println("Introduce un numero para la sucesion");
                numeroFibonnaci = escaner.nextInt();
                numeroValido = true;


            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Debes introducir un número válido.");
                escaner.nextLine(); // Limpiar el buffer del escáner para evitar un bucle infinito
                continue; // Volver al inicio del bucle
            }

        } while (!numeroValido);

        Exercisi4 fil = new Exercisi4();
        fil.start();


        System.out.println("Escriu 'exit' per interrompre el càlcul: ");
        String input = escaner.next();

        if (input.equals("exit")) {
            fil.interrupt();//interrumpe la ejecución del thread
            System.out.println("Missatge filPrincipal: Fil interromput.");
            System.out.println("Missatge filPrincipal: Programa finalitzat.");
        } else {
            escaner.close();
        }
    }


    public void run() {
        long a = 1, b = 1;
        System.out.println("Fil executant-se.");
        for (int i = 0; i < numeroFibonnaci; i++) {
            System.out.println(a);
            long next = a + b;
            a = b;
            b = next;

            try {
                Thread.sleep(3000); //dar tiempo suficiente a introducir por entrada del scanner
            } catch (InterruptedException e) {
                //en caso de interrumpir el hilo de ejecución por el exit del usuario
                //o por cualquier otro motivo se muestra este mensaje
                System.out.println("Fil interromput.");
                return;
            }
        }
        System.out.println("Programa finalitzat.");
        System.exit(0); //porque si no el scanner se queda esperando una entrada del usuario
    }



}

