package Exercisi9;


import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix un text: ");
        String text = scanner.nextLine();

        String filePath = "resultats.txt";
        Semaphore semaphore = new Semaphore(1); // Semàfor per controlar l'accés a l'arxiu

        Exercisi9[] threads = new Exercisi9[5];
        char[] vocals = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < 5; i++) {
            threads[i] = new Exercisi9(text, vocals[i], filePath, semaphore);
            threads[i].start();
        }

        for (Exercisi9 thread : threads) {
            try {
                thread.join(); // Espera a que tots els fils hagin acabat
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostra el contingut de l'arxiu per pantalla
        System.out.println("Resultats:");
        Scanner fileScanner = new Scanner(filePath);
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();

        System.out.println("Programa finalitzat");
    }
}
