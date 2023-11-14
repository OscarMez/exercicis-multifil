package Exercisi10;

public class Main10 {
    public static void main(String[] args) {
        Exercisi10 ticThread = new Exercisi10("TIC");
        Exercisi10 tacThread = new Exercisi10("TAC");
        Exercisi10 tocThread = new Exercisi10("TOC");

        ticThread.start();
        tacThread.start();
        tocThread.start();

        try {
            ticThread.join();
            tacThread.join();
            tocThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Mbappe ha llegado");
    }
}