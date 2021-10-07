package concurrency;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        count = 0;
        buffer = new int[10];

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable producerTask = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    producer.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Done producing.");
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    consumer.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Done consuming.");
        };

        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Buffer Size " + count);
    }

    private static int count;
    private static int[] buffer;

    private static final Object key = new Object();

    static class Producer {
        public void producer() throws InterruptedException {
            synchronized (key) {
                if (isFull()) key.wait();

                buffer[count++] = 1;
                key.notify();
            }

        }
    }

    static class Consumer {
        public void consumer() throws InterruptedException {
            synchronized (key) {
                if (isEmpty()) key.wait();

                buffer[--count] = 0;
                key.notify();
            }
        }
    }

    private static boolean isEmpty() {
        return count == 0;
    }

    private static boolean isFull() {
        return count == buffer.length;
    }
}
