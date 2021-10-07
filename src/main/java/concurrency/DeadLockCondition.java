package concurrency;

public class DeadLockCondition {

    public static void main(String[] args) throws InterruptedException {
        DeadLockCondition dc = new DeadLockCondition();

        Runnable runnable1 = dc::a;
        Runnable runnable2 = dc::b;

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            System.out.println("Thread " + Thread.currentThread().getName() + " in a()");
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            System.out.println("Thread " + Thread.currentThread().getName() + " in b()");
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println("Thread " + Thread.currentThread().getName() + " in c()");
        }
    }
}
