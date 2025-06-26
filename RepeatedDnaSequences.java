
/**
 * 🧬 LeetCode 187 – Repeated DNA Sequences
 *
 * ✅ Problem Description:
 * A DNA string is a sequence of characters containing only 'A', 'C', 'G', and 'T'.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur
 * more than once in a DNA molecule.
 *
 * 📥 Sample Input:
 * s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * 📤 Sample Output:
 * ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 💡 Explanation:
 * These 10-letter substrings appear more than once in the input string.
 *
 * ⏱️ Time Complexity: O(n) – where n is the length of the string.
 * ⏱️ Space Complexity: O(n) – sets store seen and repeated substrings.
 */

import java.util.*;

public class RepeatedDnaSequences {

    /**
     * Function to find all 10-letter substrings that appear more than once
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // Traverse all substrings of length 10
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            // If already in 'seen', it’s a repeat
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }

        // Convert set to list and return
        return new ArrayList<>(repeated);
    }

    /**
     * Main method to accept input and display repeated sequences
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter DNA string: ");
        String input = sc.nextLine();

        List<String> result = findRepeatedDnaSequences(input);
        System.out.println("Repeated 10-letter sequences:");
        for (String seq : result) {
            System.out.println(seq);
        }

        sc.close();
    }
}
