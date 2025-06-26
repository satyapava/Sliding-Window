/**
 * 🔠 Longest Substring Where Vowels Occur Even Number of Times
 *
 * ✅ Problem Description:
 * Given a string s, return the length of the longest substring where
 * each of the vowels 'a', 'e', 'i', 'o', 'u' occurs an even number of times (including zero).
 *
 * 📥 Sample Input:
 * s = "eleetminicoworoep"
 *
 * 📤 Sample Output:
 * 13
 *
 * 🧠 Explanation:
 * The longest substring where all vowels appear an even number of times is:
 * "leetminicowor" — from index 1 to 13 (0-based indexing).
 *
 * ⏱️ Time & Space Complexity:
 * Time Complexity: O(n) - where n is the length of the string.
 * Space Complexity: O(1) - since there are only 32 possible vowel states (2^5),
 *                  the hashmap will store a maximum of 32 entries.
 */

import java.util.*;

public class LongestSubstringVowelsEven {

    /**
     * Function to find the length of the longest substring where each vowel appears even times
     */
    public static int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each vowel state (bitmask)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initial state (all vowels even) at index -1

        int maxLength = 0;
        int state = 0; // Bitmask: a=0, e=1, i=2, o=3, u=4

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Flip the bit corresponding to the vowel
            if (ch == 'a') state ^= (1 << 0);
            else if (ch == 'e') state ^= (1 << 1);
            else if (ch == 'i') state ^= (1 << 2);
            else if (ch == 'o') state ^= (1 << 3);
            else if (ch == 'u') state ^= (1 << 4);

            // If the same state was seen before, update maxLength
            if (map.containsKey(state)) {
                maxLength = Math.max(maxLength, i - map.get(state));
            } else {
                // Store the first occurrence of this state
                map.put(state, i);
            }
        }

        return maxLength;
    }

    /**
     * Main method to accept dynamic input and print the result
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int result = findTheLongestSubstring(s);
        System.out.println("Length of longest substring: " + result);

        sc.close();
    }
}
