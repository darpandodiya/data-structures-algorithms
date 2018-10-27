package problems;

/**
 * Taken from https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-coin-change-problem/
 */

public class MinCoinChange {
    public int minCoinDynamic(int amount, int[] coins) {
        // this will store the optimal Main
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount+1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int coin : coins) {
                if (coin <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to Main of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - coin] + 1, coinReq[amt]);
                }
            }
        }
        //return the optimal Main for amount
        return coinReq[amount];

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 7;
        MinCoinChange m = new MinCoinChange();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + m.minCoinDynamic(amount, coins));
    }
}
