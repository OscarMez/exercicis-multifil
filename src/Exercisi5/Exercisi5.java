package Exercisi5;

class Exercisi5 extends Thread {
    private String message;

    public void prueba5_1(){
        Exercisi5 ticThread = new Exercisi5("TIC");
        Exercisi5 tacThread = new Exercisi5("TAC");

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

    public Exercisi5(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {  // Cambia 5 por el número de veces que quieres que se repita "TIC TAC"
            System.out.println(message + " ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



