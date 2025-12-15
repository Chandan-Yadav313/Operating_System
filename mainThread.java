
class threadMain extends Thread{

    public void run(){
        System.out.println("Current thread is: " + Thread.currentThread().getName());
    }
}





public class mainThread {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // System.out.println("Current Thread: " + Thread.currentThread().getName());
        threadMain task0 = new threadMain();
        task0.start();
        
    }
    
}
