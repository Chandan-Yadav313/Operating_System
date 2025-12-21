import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallableTask implements Callable<Integer> {

    private int num;

    public MyCallableTask(int n) {
        this.num = n;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}

public class myCallable {
    public static void main(String[] args) throws Exception {
        int n = 10;

        MyCallableTask task = new MyCallableTask(n);
        ExecutorService manager = Executors.newCachedThreadPool();

        Future<Integer> future = manager.submit(task);

        System.out.println("Sum of " + n + " is: " + future.get());

        manager.shutdown();
    }
}