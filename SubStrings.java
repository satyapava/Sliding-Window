/******************************************************************************
 * 📌 Problem: Count Substrings with All Same Characters of Length k
 *
 * 🔍 Description:
 * Given a string `s` and an integer `k`, count the number of substrings
 * of length `k` where all characters are the same.
 * 
 * ✅ Example:
 * Input:
 * s = "aaabbbaaaccc", k = 3
 * Output:
 * 3
 * Explanation:
 * Substrings of length 3 with all same characters are: "aaa", "bbb", "aaa"
 *
 * 🧠 Approach:
 * → Use a sliding window of size k
 * → Maintain a HashMap of character frequencies in the window
 * → If the map size is 1 (only one unique character in window), it's valid
 *
 * ⏱ Time Complexity: O(n), where n is length of string
 * 🗂 Space Complexity: O(k), due to sliding window hashmap
 ******************************************************************************/

import java.util.*;

public class SubStrings
{
    /**
     * Counts substrings of length k where all characters are the same
     */
    public static int count(String s, int k) {
        int n = s.length();
        int ans = 0;

        // HashMap to track character frequency in current window of size k
        HashMap<Character, Integer> hm = new HashMap<>();

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Check if the first window is valid
        if (hm.size() == 1) ans++;

        // Slide the window from left to right
        for (int i = 1; i <= n - k; i++) {
            char outChar = s.charAt(i - 1);         // character going out
            char inChar = s.charAt(i + k - 1);      // character coming in

            // Decrease frequency or remove if zero
            hm.put(outChar, hm.get(outChar) - 1);
            if (hm.get(outChar) == 0) {
                hm.remove(outChar);
            }

            // Add the new character
            hm.put(inChar, hm.getOrDefault(inChar, 0) + 1);

            // If only one character exists in map => valid substring
            if (hm.size() == 1) ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // Take input value of k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Compute result
        int ans = count(s, k);

        // Output result
        System.out.println("The count of substrings of length " + k + 
                           " consisting of same characters: " + ans);
    }
}
