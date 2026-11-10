package tasks;

import java.util.Random;

import model.CentralSoldadura;
import model.SupervisorCentral;

public class RobotTask extends Thread {

    private int id;

    CentralSoldadura centralSoldadura;
    Random emergencia = new Random();

    // Li assignam la central de soldadura al robot
    public RobotTask(int id, CentralSoldadura centralSoldadura) {
        this.id = id;
        this.centralSoldadura = centralSoldadura;
    }

    @Override 
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                SupervisorCentral.verificaEstat(id);
                // Sol·licita accés
                centralSoldadura.getEstacionsSoldadura().acquire();
                // Entra
                if (emergencia.nextInt(10) == 0) {
                    SupervisorCentral.paradaEmergencia(id);
                }
            }
        } catch {
            Thread.currentThread().interrupt();;
        }
    }

}
