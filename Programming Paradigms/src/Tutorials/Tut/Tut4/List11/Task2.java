package Tutorials.Tut.Tut4.List11;

public class Task2 {
    private static int money = 1000;
    public static void main (String[] args){
        Runnable income = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("This is an income " + threadName);
            money = money + 100;
            System.out.println("Total Money " + money);
            money = money + 500;
            System.out.println("Total Money " + money);
            money = money + 100;
            System.out.println("Total Money " + money);
            money = money + 10;
            System.out.println("Total Money " + money);
        };

        Runnable outcome = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("This is an outcome " + threadName);
            money = money - 50;
            System.out.println("Total Money " + money);
        };

        Thread thread1 = new Thread(outcome);
        Thread thread2 = new Thread(income);
        thread1.start();
        thread2.start();
    }
}

/** TASK 2:
 * The problem if we don't use synchronization in the code above comes when
 * we run it and it prints something like this:
 *
 * Total Money 1050
 * Total Money 1550
 * Total Money 1650
 * Total Money 1660
 * Total Money 950
 *
 *  It tells that your current money is 950. That is false.
 *
 *  Also another problem is when we run it more than once. It could give us
 *  different results. Sometimes the 'Total Money' is different between executions.
 */
