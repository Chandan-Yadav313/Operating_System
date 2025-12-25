import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

class Producer implements Runnable {
    private Queue<Cloths> q;
    private int maxLimit;
    private String name;

    public Producer(Queue<Cloths> que, int mL, String n) {
        this.q = que;
        this.maxLimit = mL;
        this.name = n;
    }

    public void run() {
        int i = 100000000;
        while (i-- > 0) {
            if (q.size() < maxLimit) {
                System.out.println(q.size() + " Add to queue " + " Producer name " + name);
                q.add(new Cloths());
            }
        }
    }

}

class Consumer implements Runnable {
    private Queue<Cloths> q;
    private String name;

    public Consumer(Queue<Cloths> que, String n) {
        this.q = que;
        this.name = n;
    }

    public void run() {
        int i = 100000000;
        while (i-- > 0) {
            if (q.size() > 0) {
                System.out.println(q.size() + " Remove from queue " + " Consumer name " + name);
                q.remove();
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

        Producer p1 = new Producer(q, maxLimit, "Prod1");
        Producer p2 = new Producer(q, maxLimit, "Prod2");
        Producer p3 = new Producer(q, maxLimit, "Prod3");

        Consumer c1 = new Consumer(q, "Cons1");
        Consumer c2 = new Consumer(q, "Cons2");
        Consumer c3 = new Consumer(q, "Cons3");
        Consumer c4 = new Consumer(q, "Cons4");
        Consumer c5 = new Consumer(q, "Cons5");
        Consumer c6 = new Consumer(q, "Cons6");
        Consumer c7 = new Consumer(q, "Cons7");
        Consumer c8 = new Consumer(q, "Cons8");

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
        Thread tc7 = new Thread(c7);
        tc7.start();
        Thread tc8 = new Thread(c8);
        tc8.start();
    }

}
