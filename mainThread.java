
class thread0 extends Thread {

    public void run() {
        System.out.println("task0 is executing");
        System.out.println("Current thread is: " + Thread.currentThread().getName());
    }
}

class thread1 implements Runnable {
    public void run() {
        System.out.println("task1 is execuitng");
        System.out.println("Current thread is: " + Thread.currentThread().getName());
    }
}

public class mainThread {
    public static void main(String[] args) {
        /* check main thread */

        System.out.println("Hello main thread!");
        System.out.println("Current Thread: " + Thread.currentThread().getName());

        /* using extends class */

        thread0 task0 = new thread0();
        task0.start();

        /* using runnable interface */

        thread1 task1 = new thread1();
        Thread t1 = new Thread(task1);
        t1.start();

    }

}
