import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

class Amount {
    int val;

}

class Inc implements Runnable {
    private Amount amt;
    private Lock l;

    public Inc(Amount a, Lock l) {
        this.amt = a;
        this.l = l;
    }

    public void run() {
        for (int i = 1; i <= 10000; i++) {
            l.lock();
            amt.val += i;
            l.unlock();
        }
    }
}

class Dec implements Runnable {
    private Amount amt;
    private Lock l;

    public Dec(Amount a, Lock l) {
        this.amt = a;
        this.l = l;
    }

    public void run() {
        for (int i = 1; i <= 10000; i++) {
            l.lock();
            amt.val -= i;
            l.unlock();
        }
    }
}

public class synchronization {
    public static void main(String[] args) throws InterruptedException {
        Amount amt = new Amount();
        Lock l1 = new ReentrantLock();

        Inc task1 = new Inc(amt, l1);
        Dec task2 = new Dec(amt, l1);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        // main thread
        System.out.println("After perfroming both inc and dec task result: " + amt.val);

    }
}
