package model;

import java.util.Random;

import tasks.RobotTask;

public class SupervisorCentral {

    // Protocol de Parada d'Emergència (Monitors Synchronized + wait()/notifyAll())

    public static synchronized void paradaEmergencia(int id) throws InterruptedException {
        Random ran = new Random();
        int numAleatori = 10;
        while (numAleatori != 0) {
            wait();
            numAleatori = ran.nextInt(5);
        }
        notifyAll();
    }

}
