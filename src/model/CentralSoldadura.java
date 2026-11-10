package model;

import java.util.concurrent.Semaphore;

public class CentralSoldadura {

    // Numero d'estacions de soldadura
    int numEstacions;

    // Estacions de Soldadura (Semaphore (N))

    Semaphore estacionsSoldadura = new Semaphore(numEstacions);

    // Tauler de Registre Central (Semaphore (1))

    Semaphore taulerRegistreCentral = new Semaphore(1);

    // Constructor
    public CentralSoldadura (int numEstacions) {
        this.numEstacions = numEstacions;
    }

    // Getters
    public Semaphore getEstacionsSoldadura() {
        return estacionsSoldadura;
    }
    public Semaphore getTaulerRegistreCentral() {
        return taulerRegistreCentral;
    }

    

}
