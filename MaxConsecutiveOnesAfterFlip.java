import java.util.*;

/*
 * Class Name: MaxConsecutiveOnesAfterFlip
 *
 * Description:
 * Learned how to use the sliding window technique to solve binary array problems.
 * The problem focuses on finding the longest subarray of 1's after flipping at most k zeros.
 * This enhances understanding of two-pointer techniques and maintaining dynamic window conditions.
 *
 * Time Complexity: O(n) — Each element is visited at most twice.
 * Space Complexity: O(1) — Uses constant extra space.
 *
 * Sample Input:
 * Enter n : 
 * 7
 * 1 0 1 1 0 0 1
 * Enter k value : 
 * 2
 *
 * Sample Output:
 * Maximum consecutive ones after flipping at most 2 zeros: 6
 */

public class MaxConsecutiveOnesAfterFlip {
    public static int maxOnes(int[] a, int n, int k) {
        int i = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int j = 0; j < n; j++) {
            if (a[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (a[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter array elements (0s and 1s only):");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        System.out.println("Maximum consecutive ones after flipping at most " + k + " zeros: " + maxOnes(a, n, k));
    }
}
