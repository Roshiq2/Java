import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class UploadResult implements Runnable {
    private String taskName;
    public UploadResult(String name) {
        taskName = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
    }
}

public class ThreadPoolTester {
    public static void main(String[] args) {
        ExecutorService exServicePool = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 6; i++) {
            UploadResult uploadRunnable = new UploadResult("UploadResult:" + i);
            exServicePool.execute(uploadRunnable);
        }
        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) {}
        System.out.println("Finished all threads");
    }
}