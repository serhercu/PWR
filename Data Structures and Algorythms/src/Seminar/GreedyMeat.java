package Seminar;

public class GreedyMeat {

    static void findRoute(int[] aux) {
        int num_People = aux[0];
        int num_Meat = 0;

        // Counts number of meatballs at array aux
        for (int i = 1; i < aux.length; i++) {
            num_Meat += aux[i];
        }

        int each = num_Meat / 2;

        // First base case
        if (num_Meat % 2 != 0) {
            System.out.println("No equal partitioning.");
            return;
        }

        for (int i = 1; i < num_People + 1; i++) {
            if (each == 0) {
                System.out.println("Sam stops at position " + (i - 1) + " and Ella stops at position " + i);
                return;
            }
            each -= aux[i];

        }
    }

    public static void main(String[] args)
    {
        findRoute(new int[]{5, 9, 4, 2, 8, 3});
        findRoute(new int[]{6, 1, 2, 1, 2, 1, 1});
        findRoute(new int[]{6, 1, 2, 1, 2, 1, 2});
        findRoute(new int[]{3, 4, 2, 2});
        findRoute(new int[]{3, 2, 2, 4});
    }
}
