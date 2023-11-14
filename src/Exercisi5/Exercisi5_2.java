package Exercisi5;



class Exercisi5_2 extends Thread {
    private String message;

    public void prueba5_2(){
        Exercisi5_2 ticThread = new Exercisi5_2("TIC");
        Exercisi5_2 tacThread = new Exercisi5_2("TAC");

        ticThread.start();
        tacThread.start();

        try {
            ticThread.join();
            tacThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalitzat");
    }

    public Exercisi5_2(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {  // Cambia 5 por el número de veces que quieres que se repita "TIC TAC"
            System.out.println(message + " ");
        }
    }
}




