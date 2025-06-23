/******************************************************************************
 * 📊  Subarray Product Less Than K
 *
 * 📌 Description
 * This Java program counts the number of contiguous subarrays whose product
 * is strictly less than a given integer k. It leverages a sliding-window
 * (two-pointer) technique to run in linear O(n) time.
 *
 * 🚀 Features
 * • Handles large input arrays efficiently (O(n) time, O(1) space)  
 * • Detects edge cases where an element equals k  
 * • Simple, self-contained main method for quick testing
 *
 * 🧠 Algorithm
 * 1. Treat the window [left .. right] and maintain its product.  
 * 2. Multiply a[right] into the product.  
 * 3. While product ≥ k, shrink from the left, dividing by a[left].  
 * 4. Each step adds (right − left + 1) valid subarrays to the answer.  
 *
 * 📂 Input / Output
 * Example Input  
 * 4  
 * 1 2 3 4  
 * 10  
 * Example Output  
 * 7
 *
 * 💻 How to Run
 * javac Main.java  
 * java Main
 *
 * 🧪 Sample Test Case
 * Input  
 * 5  
 * 10 5 2 6 1  
 * 100  
 * Output  
 * 19
 *
 * ✍️ Author: Sivalokesh Perisetty — June 2025
 ******************************************************************************/

import java.util.*;

public class SubarrayProd {

    /** Returns the count of contiguous subarrays with product < k */
    public static int count(int n, int k, int[] a) {
        // If any element equals k, no valid subarray can include it alone
        for (int val : a) {
            if (val == k) return 0;
        }

        int ans = 0, left = 0, product = 1;

        for (int right = 0; right < n; right++) {
            product *= a[right];

            // Shrink window until product < k
            while (product >= k && left < right) {
                product /= a[left];
                left++;
            }

            // Add all subarrays ending at 'right'
            ans += (right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Enter array elements:");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = count(n, k, a);
        System.out.println("The count of subarrays where product is less than k: " + result);
    }
}
