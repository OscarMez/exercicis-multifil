package Exercisi10;

import java.util.concurrent.Semaphore;

class Exercisi10 extends Thread {
    private static Semaphore ticSemaphore = new Semaphore(1);
    private static Semaphore tacSemaphore = new Semaphore(0);
    private static Semaphore tocSemaphore = new Semaphore(0);

    private String message;

    public Exercisi10(String message) {
        this.message = message;
    }

    public void run() {
        int iterations = 5;  // Modifica aquest valor si vols mostrar la seqüència més vegades

        for (int i = 0; i < iterations; i++) {
            try {
                if (message.equals("TIC")) {
                    ticSemaphore.acquire();
                } else if (message.equals("TAC")) {
                    tacSemaphore.acquire();
                } else if (message.equals("TOC")) {
                    tocSemaphore.acquire();
                }

                System.out.println(message);
                Thread.sleep(500);  // Espera per apreciar com van apareixent els missatges a la consola

                if (message.equals("TIC")) {
                    tacSemaphore.release();
                } else if (message.equals("TAC")) {
                    tocSemaphore.release();
                } else if (message.equals("TOC")) {
                    ticSemaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


