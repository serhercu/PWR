package Seminar;

class GreedyChange {

    static double[] notes_coins = {20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05};

    static void findCoins(double cost, double offer) {
        String result = "";
        String good_NoteCoin;
        int count;
        double change;

        // First base case
        if (cost == 0.00 && offer == 0.00) {
            return;
        }

        // Swedish rounding method
        cost = cost * 10;
        int decimal = (int) cost;
        double fractional = (cost) - decimal;

        if (fractional < 0.3) { cost = cost - fractional; }
        else if (fractional >= 0.3 && fractional < 0.8) { cost = decimal + 0.5; }
        else if (fractional > 0.7) { cost += 1; cost = cost - fractional; }

        cost = cost / 10;

        // Base cases
        if (cost > offer) {
            result = "Not enough money offered.";
        } else if (cost == offer) {
            result = "Exact amount.";
        }

        // Greedy
        else {
            change = offer - cost;
            change = Math.round(change * 100.0) / 100.0;

            for (int i = 0; i < notes_coins.length; i++) {
                count = 0;
                while (notes_coins[i] <= change) {
                    change -= notes_coins[i];
                    count++;
                }
                if (count > 0) {
                    if (notes_coins[i] >= 1) {
                        good_NoteCoin = "$" + (int) notes_coins[i] + "*" + count;
                    } else {
                            good_NoteCoin = (int) (notes_coins[i] * 100) + "c*" + count;
                    }
                    result += (good_NoteCoin + " ");
                }
            }
        }
        System.out.print(result + "\n");
    }

    public static void main(String[] args)
    {
        findCoins(20.03, 20.00);
        findCoins(20.03, 20.03);
        findCoins(0.09, 0.10);
        findCoins(20, 25);
        findCoins(0.07, 0.10);
        findCoins(42.00, 60);
        findCoins(42.00, 60.10);
        findCoins(40.00, 40.05);
    }
}
