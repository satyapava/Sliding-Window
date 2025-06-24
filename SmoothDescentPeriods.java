import java.util.*;

/*
 * Class Name: SmoothDescentPeriods
 * Description:
 * Learned how to identify and count smooth descent periods in a stock price array.
 * A smooth descent period is defined as a contiguous subarray where each element is exactly 1 less than the previous.
 * Practiced efficient prefix counting and subarray summation logic using linear iteration.
 *
 * Time Complexity: O(n) - Traverses the array once.
 * Space Complexity: O(1) - Uses only a few integer variables.
 *
 * Sample Input:
 * Enter n : 
 * 5
 * 3 2 1 4 3
 *
 * Sample Output:
 * Maximum number of smooth descent periods : 9
 */

public class SmoothDescentPeriods {
    public static int countDescentPeriod(int prices[], int n) {
        int ans = 1;  // Each single element is a descent period
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count++;
            } else {
                count = 1;
            }
            ans += count;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int r = countDescentPeriod(prices, n);
        System.out.println("Maximum number of smooth descent periods : " + r);
    }
}
