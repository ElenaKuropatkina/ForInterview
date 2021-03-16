package lesson3.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    int i;
    Lock lock = new ReentrantLock();
    boolean flag = false;

    public void increment() {
        while (!flag) {
            lock.lock();
            try {
                i++;
                System.out.println(i);
                flag = true;
            } finally {
                lock.unlock();
            }
        }
    }

    public void decrement() {
        while (flag) {
            lock.lock();
            try {
                i--;
                System.out.println(i);
                flag = false;
            } finally {
                lock.unlock();
            }
        }
    }

}
