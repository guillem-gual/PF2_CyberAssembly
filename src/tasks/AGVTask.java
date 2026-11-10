package tasks;

import model.CintaTransportadora;
import model.SupervisorCentral;

public class AGVTask extends Thread{

    private int id;
    private int comptador = 0;

    private CintaTransportadora cinta;

    public AGVTask (int id, CintaTransportadora cinta){
        this.id = id;
        this.cinta = cinta;
    }

    @Override 
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                cinta.afegirBateria(id, comptador);
                comptador ++;
                Thread.sleep(900);
            }
        } catch {
            Thread.currentThread().interrupt();;
        }
    }
}
