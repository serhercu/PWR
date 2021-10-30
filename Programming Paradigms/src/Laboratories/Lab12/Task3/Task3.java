package Laboratories.Lab12.Task3;

import java.util.ArrayList;
import java.util.Collection;

public class Task3 {

    public static double sum(Collection<? extends Number> c) {
        double total = 0;
        for (Number num : c){
            total = total + num.doubleValue();
        }
        return total;
    }

    public static void main(String[] args){
    Collection <Double> c = new ArrayList<>();
    c.add(6.4);
    c.add(-9.0);
    System.out.println(sum(c));
    }
}
