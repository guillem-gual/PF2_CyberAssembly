package model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CintaTransportadora {

    int capacitatMaxima = 10;

    // ReentrantLock 
    ReentrantLock lock = new ReentrantLock();

    // Condition (cintaNoPlena i cintaNoBuida)
    Condition cintaNoPlena = lock.newCondition();
    Condition cintaNoBuida = lock.newCondition();

    public void afegirBateria(int id, int comptador) throws InterruptedException {
        lock.lock();
        try {
            // Si esta plena, esperam la condició cintaNoPlena
            cintaNoPlena.await();
            // Accés a la secció crítica
            cintaNoBuida.signal();
        } finally {
            lock.unlock();
        }
    }

}
