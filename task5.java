public class task5 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("I am inner Thread " +i);
                }
            }

        });
        t.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("I am main Thread " +i);
        }
    }
}
