package model;

import java.util.Random;

import tasks.RobotTask;

public class SupervisorCentral {

    // Protocol de Parada d'Emergència (Monitors Synchronized + wait()/notifyAll())

    public static synchronized void paradaEmergencia(RobotTask rt) throws InterruptedException {
        Random ran = new Random();
        int numAleatori = 10;
        while (numAleatori != 0) {
            rt.wait();
            Thread.sleep(1000);
            numAleatori = ran.nextInt(5);
        }
        rt.notifyAll();
    }

}
