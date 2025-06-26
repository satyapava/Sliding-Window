/**
 * 🍞 Minimum Days to Survive
 *
 * ✅ Problem Description:
 * A person needs to survive for `S` days. The person can buy at most `N` units of food each day.
 * The person requires `M` units of food each day to survive.
 *
 * Find the **minimum number of days** on which the person needs to buy food to survive all `S` days.
 * If it is **not possible to survive**, return -1.
 *
 * 📥 Sample Input:
 * S = 10 (days)
 * N = 16 (max food units per day)
 * M = 2  (food needed per day)
 *
 * 📤 Sample Output:
 * 2
 *
 * 💡 Explanation:
 * Total food required = 10 * 2 = 20 units.
 * He can buy at most 16 units per day → needs at least 2 days to buy 20 units (16+4).
 *
 * ⏱️ Time Complexity: O(1)
 * ⏱️ Space Complexity: O(1)
 */

import java.util.*;

public class minimumdays {

    /**
     * Function to calculate the minimum number of days to buy food
     */
    static int minimumDays(int S, int N, int M) {

        // If daily need is more than what can be bought in a day, survival is impossible
        if (M > N) {
            return -1;
        }

        // If person cannot buy enough food for 7 days during the 6 days (Sunday closed)
        if ((N * 6) < (M * 7) && S > 6) {
            return -1;
        }

        // Total food required for S days
        int totalFoodNeeded = S * M;

        // Minimum number of days required to buy that much food
        int minDays = (totalFoodNeeded + N - 1) / N; // ceiling division

        return minDays;
    }

    /**
     * Main method to take dynamic input
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of survival days (S): ");
        int S = sc.nextInt();

        System.out.print("Enter max units of food per day (N): ");
        int N = sc.nextInt();

        System.out.print("Enter units of food needed per day (M): ");
        int M = sc.nextInt();

        int result = minimumDays(S, N, M);

        if (result == -1) {
            System.out.println("Survival is not possible.");
        } else {
            System.out.println("Minimum days to buy food: " + result);
        }

        sc.close();
    }
}
