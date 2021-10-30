package Laboratories.Lab12.Task3;

import java.util.ArrayList;
import java.util.Collection;

public class SumNumbers {
	
	
	public static double sum(Collection<? extends Number> c) {
		double res= 0;
		for (Number n : c) {
			res = res +  n.doubleValue();
		}
		return res;
		
	}

	public static void main(String[] args) {
		Collection <Integer> c = new ArrayList<>();
		c.add(6);
		c.add(-9);
		System.out.println(sum(c));
		
		
		Collection <Double> d = new ArrayList<>();
		d.add(6.0);
		d.add(-9.0);
		d.add(1562.35);
		System.out.println(sum(d));
		
		
		Collection <Byte> e = new ArrayList<>();
		e.add((byte) 7);
		e.add((byte) 75);
		System.out.println(sum(e));
		
		
	}

}
