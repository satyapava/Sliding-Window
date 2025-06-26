
/**
 * 🧮 Find Subarray with Given Sum (GFG-style problem)
 *
 * ✅ Problem Description:
 * Given an array of positive integers and a target sum, find the **starting and ending position**
 * (1-based index) of the first subarray whose elements sum up to the target.
 * If no such subarray exists, return [-1].
 *
 * 📥 Sample Input:
 * arr = [1, 2, 3, 7, 5]
 * target = 12
 *
 * 📤 Sample Output:
 * [2, 4]
 *
 * 💡 Explanation:
 * The subarray [2, 3, 7] adds up to 12 and starts at index 2 and ends at index 4 (1-based).
 *
 * ⏱️ Time Complexity: O(n) – single pass using sliding window
 * ⏱️ Space Complexity: O(1) – constant space used (excluding output)
 */

import java.util.*;

public class SubarrayWithGivenSum {

    // Function to find the subarray with the given sum
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int sum = 0;

        for (int j = 0; j < n; j++) {
            sum += arr[j];

            // Shrink the window from the left if sum exceeds target
            while (sum > target && i < j) {
                sum -= arr[i];
                i++;
            }

            // If subarray found
            if (sum == target) {
                ans.add(i + 1); // +1 for 1-based indexing
                ans.add(j + 1);
                return ans;
            }
        }

        // No subarray found
        ans.add(-1);
        return ans;
    }

    // Main method for dynamic input and output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Function call
        ArrayList<Integer> result = subarraySum(arr, target);

        // Output result
        System.out.println("Output: " + result);

        sc.close();
    }
}
