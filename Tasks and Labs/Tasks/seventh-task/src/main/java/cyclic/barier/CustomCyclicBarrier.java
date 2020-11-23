package cyclic.barier;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomCyclicBarrier {
    private static final Logger log = Logger.getLogger(CustomCyclicBarrier.class.getName());
    private int amountOfThreads;
    private int threadsAwait;
    private Runnable cyclicBarrierEvent;

    public CustomCyclicBarrier(int amountOfThreads, Runnable cyclicBarrierEvent) {
        this.amountOfThreads = amountOfThreads;
        this.threadsAwait = amountOfThreads;
        this.cyclicBarrierEvent = cyclicBarrierEvent;
    }

    public synchronized void await(){
        --this.threadsAwait;
        while(this.threadsAwait > 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.log(Level.SEVERE, "Exception: ", e);
            }
        }
        notifyAll();
        threadsAwait = amountOfThreads;
        cyclicBarrierEvent.run();
    }

    public int getAmountOfThreads() {
        return amountOfThreads;
    }

    public int getThreadsAwait() {
        return threadsAwait;
    }
}
