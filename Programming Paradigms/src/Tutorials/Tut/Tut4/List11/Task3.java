package Tutorials.Tut.Tut4.List11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static int money = 1000;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            System.out.println("This is an income " + Thread.currentThread().getName());
            money = money + 100;
            money = money + 500;
            money = money + 100;
            money = money + 10;
            System.out.println("Total Money " + money);
        });
        executor.submit(() -> {
            System.out.println("This is an outcome " + Thread.currentThread().getName());
            money = money - 50;
            System.out.println("Total Money " + money);
        });
        executor.shutdown();
    }
}
