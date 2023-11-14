package Exercisi9;

import java.io.FileWriter;
import java.io.IOException;

import java.util.concurrent.Semaphore;

class Exercisi9 extends Thread {
    private String text;
    private char vocal;
    private String filePath;
    private Semaphore semaphore;

    public Exercisi9(String text, char vocal, String filePath, Semaphore semaphore) {
        this.text = text;
        this.vocal = vocal;
        this.filePath = filePath;
        this.semaphore = semaphore;
    }

    public void run() {
        int count = countVocals();
        writeToFile(count);
    }

    private int countVocals() {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                count++;
            }
        }
        return count;
    }

    private void writeToFile(int count) {
        try {
            semaphore.acquire(); // Adquireix el semàfor per accedir a l'arxiu

            FileWriter writer = new FileWriter(filePath); // Obrir l'arxiu en mode d'adjunció
            writer.write("Vocal " + vocal + ": " + count + " vegades\n");
            writer.close();

            semaphore.release(); // Allibera el semàfor després d'escriure a l'arxiu
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



