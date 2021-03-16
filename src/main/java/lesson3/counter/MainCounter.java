package lesson3.counter;

public class MainCounter {
    public static void main(String[] args) {

        final Counter counter = new Counter();

        Thread incThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    counter.increment();
                }
            }
        });

        Thread decThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    counter.decrement();
                }
            }
        });

        incThread.start();
        decThread.start();
    }
}
