/**
 * 🍬 Distribute N Candies Among K People
 *
 * ✅ Problem Description:
 * You are given N candies and K people standing in a line. You need to distribute the candies such that:
 * - On the first round, the 1st person gets 1 candy, the 2nd gets 2 candies, ..., the Kth gets K candies.
 * - On the next round, the 1st gets K+1 candies, the 2nd gets K+2 candies, ..., the Kth gets 2K candies, and so on.
 * - If at any point the remaining candies are less than required, give the remaining candies to the current person and stop.
 *
 * 📥 Sample Input 1:
 * N = 7, K = 4
 * 📤 Output:
 * 1 2 3 1
 *
 * 📥 Sample Input 2:
 * N = 10, K = 3
 * 📤 Output:
 * 5 2 3
 *
 * ⏱️ Time Complexity: O(N) in worst case (or O(√N) optimized distribution)
 */

import java.util.*;

public class distributeCandie {

    public static int[] distributeCandies(int N, int K) {
        int[] res = new int[K];
        int give = 1;  // Starting candy count

        int i = 0;
        while (N > 0) {
            // Current person in line
            int idx = i % K;

            // Give min(candies left, required candies)
            int toGive = Math.min(N, give);
            res[idx] += toGive;
            N -= toGive;

            give++;  // Increase next candy count
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of candies and number of people
        System.out.print("Enter number of candies (N): ");
        int N = sc.nextInt();

        System.out.print("Enter number of people (K): ");
        int K = sc.nextInt();

        int[] result = distributeCandies(N, K);

        // Output the result
        System.out.print("Final distribution: ");
        for (int candies : result) {
            System.out.print(candies + " ");
        }
        System.out.println();

        sc.close();
    }
}
