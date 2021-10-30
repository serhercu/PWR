package Tutorials.Tut.Tut4.List11;

import java.util.concurrent.*;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(1);
        int c = 0;
        int finalC = c;
        Runnable task = () ->
                System.out.println(finalC);
        for(int i = 0; i <= 30;i++) {
            ScheduledFuture<?> future = executor.schedule(task, i,
                    TimeUnit.SECONDS);
            c = c + 1;
        }
        executor.shutdown();
    }
}

