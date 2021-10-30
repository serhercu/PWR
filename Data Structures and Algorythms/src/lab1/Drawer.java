package lab1;

public class Drawer {
    private static void drawLine(int n, char ch) {
        // TODO
        int aux = n * 2 - 1;
        for (int i = 1; i < aux; i++) {
            System.out.print(ch);
        }
        System.out.println(ch);
    }


    public static void drawPyramid(int n) {
        // TODO
        for (int i = 1; i <= n; i++){
            for(int j = 0; j <= n - i; j++){
                System.out.print(" ");
            }
            drawLine(i, 'X');
        }
    }


    public static void drawChristmassTree(int n) {
        // TODO
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++){
                for(int s = 1; s <= n - j; s++){
                    System.out.print(" ");
                }
                drawLine(j, 'X');
            }
        }
    }
}
