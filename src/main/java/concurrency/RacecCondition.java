package concurrency;

public class RacecCondition {
    public static void main(String[] args) throws InterruptedException {
        RacecCondition rc = new RacecCondition();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++)
                rc.increment();
        };

        Thread[] threads = new Thread[1_000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(rc.l);
    }

    private long l = 0;

    /*
        Remove Synchronized to meet Race Condition
     */
    private synchronized void increment() {
        l ++;
    }
}
