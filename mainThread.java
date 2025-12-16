import java.io.InterruptedIOException;

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

class mythread1 implements Runnable {
    public void run() {
        System.out.println("Creating thread 1 to 100 using runnable interface");
        int i = 100;
        while (i-- > 0) {
            System.out.println("Current thread is: " + Thread.currentThread().getName());

        }
        System.out.println("Times Ups!!");
    }
}

class mythread2 extends Thread {
    public void run() {
        System.out.println("Creating thread 1 to 100 using extends thread class");
        int i = 100;
        while (i-- > 0) {
            System.out.println("Current thread is: " + Thread.currentThread().getName());

        }
        System.out.println("Times over!");
    }
}

class mythread3 extends Thread {
    public void run() {
        System.out.println("Creating thread 1 to 100 using extends thread class");
        int i = 100;
        while (i-- > 0) {
            System.out.println("Current thread is: " + Thread.currentThread().getName());

        }
        System.out.println("The End!");
    }
}

class mythread4 extends Thread {
    private int number;

    public mythread4(int num) {
        this.number = num;
    }

    public void run() {
        System.out.println("Current thread: " + number + " " + Thread.currentThread().getName());

    }
}

public class mainThread {
    public static void main(String[] args) throws InterruptedException {
        /* check main thread */

        // System.out.println("Hello main thread!");
        // System.out.println("Current Thread: " + Thread.currentThread().getName());

        /* using extends class */

        // thread0 task0 = new thread0();
        // task0.start();

        /* using runnable interface */

        // thread1 task1 = new thread1();
        // Thread t1 = new Thread(task1);
        // t1.start();

        /* printing 1 to 100 thread using runnable interface and extends thread class */

        // mythread1 task1 = new mythread1();
        // Thread t1 = new Thread(task1);
        // t1.start();

        // mythread2 task2 = new mythread2();
        // task2.start();

        // mythread3 task3 = new mythread3();
        // task3.start();

        /* Creating 1 to 100 threads using for loops and contructions */
        System.out.println("Time start to execute task from 1 to 100");
        for (int i = 1; i <= 100; i++) {
            mythread4 task4 = new mythread4(i);
            task4.start();
            Thread.sleep(1000);
        }

        System.out.println("Times Ups!!");

    }

}
