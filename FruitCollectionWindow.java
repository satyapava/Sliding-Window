import java.util.*;

/*
 * Class Name: FruitCollectionWindow
 * Description:
 * Learned how to solve the "Longest Subarray with at Most Two Distinct Elements" problem using the sliding window technique and HashMap.
 * Practiced maintaining frequency maps and adjusting window bounds dynamically.
 *
 * Time Complexity: O(n), where n is the size of the array.
 * Space Complexity: O(1), at most 3 keys in the HashMap (since only 2 distinct fruits allowed).
 *
 * Sample Input:
 * 5
 * 1 2 1 2 3
 *
 * Sample Output:
 * Maximum friuts are 4
 */

public class FruitCollectionWindow {
    public static int collect(int a[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;

        while (j < n) {
            hm.put(a[j], hm.getOrDefault(a[j], 0) + 1);

            // If more than 2 types of fruits, shrink the window from the left
            while (hm.size() > 2) {
                hm.put(a[i], hm.get(a[i]) - 1);
                if (hm.get(a[i]) == 0) {
                    hm.remove(a[i]);
                }
                i++;
            }

            // Update the max length window that contains at most 2 fruit types
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int r = collect(a, n);
        System.out.println("Maximum friuts are " + r);
    }
}
