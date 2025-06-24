import java.util.*;

/*
 * Class Name: CountAllDistinctCharSubstrings
 *
 * Description:
 * Learned how to apply the sliding window technique and sets to find the count of all substrings
 * in a string where all characters are distinct. This approach helps in mastering character frequency tracking,
 * optimal window expansion, and shrinking techniques in strings.
 *
 * Time Complexity: O(n) — Each character is processed at most twice (once added and once removed).
 * Space Complexity: O(k) — Where k is the size of the character set used in the string (worst case O(n)).
 *
 * Sample Input:
 * Enter a string: abca
 *
 * Sample Output:
 * Total substrings with all distinct characters: 9
 *
 * Explanation:
 * Valid substrings are: a, b, c, ab, bc, ca, abc, bca, abca (excluding repeated chars in substrings)
 */

public class CountAllDistinctCharSubstrings {
    // Function to count all substrings with all distinct characters
    public static int countAllDistinctCharSubstrings(String s) {
        int n = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Shrink window if character repeats
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            // Add number of substrings ending at right and having all unique chars
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = countAllDistinctCharSubstrings(s);
        System.out.println("Total substrings with all distinct characters: " + result);
    }
}
