
class thread0 extends Thread{

    public void run(){
        System.out.println("Current thread is: " + Thread.currentThread().getName());
    }
}







public class mainThread {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // System.out.println("Current Thread: " + Thread.currentThread().getName());
        thread0 task0 = new thread0();
        task0.start();
        
    }
    
}
