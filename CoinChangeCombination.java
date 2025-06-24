import java.util.*;

/*
 * Class Name: CoinChangeCombination
 * Description:
 * Learned how to compute the number of combinations to form a target sum using given coin denominations.
 * This is a variation of the coin change problem using dynamic programming with a 1D array for space optimization.
 *
 * Time Complexity: O(n * t), where n is the number of coins and t is the target.
 * Space Complexity: O(t), using a 1D dp array of size (target + 1).
 *
 * Sample Input:
 * 3
 * 1 2 3
 * 4
 *
 * Sample Output:
 * NO of combinations are 4
 */

public class CoinChangeCombination {
    public static int count(int a[], int n, int t) {
        int dp[] = new int[t + 1];
        dp[0] = 1;  // base case

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] <= i) {
                    dp[i] = dp[i] + dp[i - a[j]];
                }
            }
        }
        return dp[t];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of coins
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // coin denominations
        }
        int t = sc.nextInt(); // target amount
        int r = count(a, n, t);
        System.out.println("NO of combinations are " + r);
    }
}
