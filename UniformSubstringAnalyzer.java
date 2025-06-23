/******************************************************************************
 * 📍 Problem: Most Frequent Uniform-Substring Character
 *
 * 📝 Description
 * Given a string `s` and an integer `k`, examine every substring of length `k`.
 * A substring is **uniform** if all of its characters are identical (e.g. "aaa").
 * Count how many uniform substrings each character forms and return the
 * character that appears in the **largest number** of such substrings.
 *
 * If several characters tie for the maximum count, the first one encountered
 * while scanning the string is returned (as dictated by the sliding-window
 * order in this implementation).
 *
 * ⏱  Complexity
 * • Time : **O(n)** – each character enters and leaves the window once.  
 * • Space : **O(k)** – hash maps store frequencies for at most `k` distinct
 *   characters (bounded by alphabet size).
 *
 * 🧪 Sample Input
 * String s :  "aaabbbaaaacc"  
 * k         :  3
 *
 * 🧾 Sample Output
 * a
 *
 * Explanation :  
 * Length-3 uniform substrings = {"aaa","bbb","aaa","aaa"}.  
 * 'a' forms 3 of them, 'b' forms 1 ⇒ result is 'a'.
 ******************************************************************************/

import java.util.*;

public class UniformSubstringAnalyzer {

    /**
     * Returns the character that forms the greatest number of
     * length-k uniform substrings in the given string.
     */
    public static char mostFrequentUniformChar(String s, int k) {
        int n = s.length();
        if (k > n) return '\0';                // no substring possible

        /* mapWindow  : char -> frequency inside current window
         * mapGlobal  : char -> count of uniform substrings contributed by that char
         */
        Map<Character, Integer> mapWindow = new HashMap<>();
        Map<Character, Integer> mapGlobal = new LinkedHashMap<>(); // preserves first-seen order

        // ---------- initialise first window of size k ----------
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            mapWindow.put(ch, mapWindow.getOrDefault(ch, 0) + 1);
        }
        if (mapWindow.size() == 1) {                 // first window is uniform
            char ch = s.charAt(0);
            mapGlobal.put(ch, 1);
        }

        // ---------- slide the window across the string ----------
        for (int left = 1; left <= n - k; left++) {
            char out = s.charAt(left - 1);           // char leaving window
            char in  = s.charAt(left + k - 1);       // char entering window

            // update window frequencies
            mapWindow.put(out, mapWindow.get(out) - 1);
            if (mapWindow.get(out) == 0) mapWindow.remove(out);

            mapWindow.put(in, mapWindow.getOrDefault(in, 0) + 1);

            // if window uniform → update global count
            if (mapWindow.size() == 1) {
                mapGlobal.put(in, mapGlobal.getOrDefault(in, 0) + 1);
            }
        }

        // ---------- find character with maximum count ----------
        char bestChar = '\0';
        int  max      = 0;
        for (Map.Entry<Character, Integer> e : mapGlobal.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                bestChar = e.getKey();
            }
        }
        return bestChar;
    }

    // ---------------------------- driver code ----------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        char result = mostFrequentUniformChar(s, k);
        if (result == '\0')
            System.out.println("No substring of length " + k + " exists.");
        else
            System.out.println("Character with maximum uniform substrings of length "
                               + k + " : " + result);
    }
}
