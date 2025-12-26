import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

class Producer implements Runnable {
    private Queue<Cloths> q;
    private int maxLimit;
    private String name;
    private Semaphore prodSema;
    private Semaphore consSema;

    public Producer(Queue<Cloths> que, int mL, String n, Semaphore ps, Semaphore cs) {
        this.q = que;
        this.maxLimit = mL;
        this.name = n;
        this.prodSema = ps;
        this.consSema = cs;
    }

    public void run() {
        int i = 10000;
        while (i-- > 0) {
            // if (q.size() < maxLimit)
            {
                try {
                    prodSema.acquire();
                    System.out.println(q.size() + " Add to queue " + " Producer name " + name);
                    q.add(new Cloths());
                    consSema.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}

class Consumer implements Runnable {
    private Queue<Cloths> q;
    private String name;
    private Semaphore prodSema;
    private Semaphore consSema;

    public Consumer(Queue<Cloths> que, String n, Semaphore ps, Semaphore cs) {
        this.q = que;
        this.name = n;
        this.prodSema = ps;
        this.consSema = cs;
    }

    public void run() {
        int i = 10000;
        while (i-- > 0) {
            // if (q.size() > 0)
            {
                try {
                    consSema.acquire();
                    System.out.println(q.size() + " Remove from queue " + " Consumer name " + name);
                    q.remove();
                    prodSema.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

class Cloths {
    String colr;
    String brand;
}

public class task6 {
    public static void main(String[] args) {
        int maxLimit = 5;
        Queue<Cloths> q = new ConcurrentLinkedDeque<>();

        Semaphore prodSema = new Semaphore(maxLimit);
        Semaphore consSema = new Semaphore(0);

        Producer p1 = new Producer(q, maxLimit, "Prod1", prodSema, consSema);
        Producer p2 = new Producer(q, maxLimit, "Prod2", prodSema, consSema);
        Producer p3 = new Producer(q, maxLimit, "Prod3", prodSema, consSema);

        Consumer c1 = new Consumer(q, "Cons1", prodSema, consSema);
        Consumer c2 = new Consumer(q, "Cons2", prodSema, consSema);
        Consumer c3 = new Consumer(q, "Cons3", prodSema, consSema);
        Consumer c4 = new Consumer(q, "Cons4", prodSema, consSema);
        Consumer c5 = new Consumer(q, "Cons5", prodSema, consSema);
        Consumer c6 = new Consumer(q, "Cons6", prodSema, consSema);
        // Consumer c7 = new Consumer(q, "Cons7", prodSema, consSema);
        // Consumer c8 = new Consumer(q, "Cons8", prodSema, consSema);

        Thread tp1 = new Thread(p1);
        tp1.start();
        Thread tc1 = new Thread(c1);
        tc1.start();
        Thread tc2 = new Thread(c2);
        tc2.start();

        Thread tp2 = new Thread(p2);
        tp2.start();
        Thread tc3 = new Thread(c3);
        tc3.start();
        Thread tc4 = new Thread(c4);
        tc4.start();

        Thread tp3 = new Thread(p3);
        tp3.start();
        Thread tc5 = new Thread(c5);
        tc5.start();
        Thread tc6 = new Thread(c6);
        tc6.start();
        // Thread tc7 = new Thread(c7);
        // tc7.start();
        // Thread tc8 = new Thread(c8);
        // tc8.start();
    }

}
