package Exercisi1;

import java.util.Random;

public class Exercisi1 extends Thread {

    public void run() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        System.out.println(Thread.currentThread().getName()+ ": Iniciat");
        System.out.println(Thread.currentThread().getName() + ": Valor " + numeroAleatorio);
        System.out.println(Thread.currentThread().getName()+ ": finalitzat");
    }


    public  void Exercisi1(){
        int fils = 5;

        for (int x=0;x < fils; x++){
            Exercisi1 fil = new Exercisi1();
            fil.setName("Fil " + x);
            fil.start();

        }
    }

}
