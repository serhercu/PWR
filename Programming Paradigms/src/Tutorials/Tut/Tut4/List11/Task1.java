package Tutorials.Tut.Tut4.List11;

public class Task1 extends Thread{
    public static void main (String[] args){
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done!");
    }
}

/** TASK 1:
 * The first code will print:
 *
 * Hello main
 * Done!
 * Hello Thread-0
 */



