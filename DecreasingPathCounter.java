/******************************************************************************
 * 📍 Problem: Strictly Decreasing Paths in a Grid
 *
 * 📝 Description
 * Given an n × m integer matrix `a`, count all possible paths from a source cell
 * (sr, sc) to a destination cell (dr, dc).  From any cell you may move
 * **up, down, left, or right** *only if* the value in the next cell is
 * **strictly smaller** than the value in the current cell.
 *
 * 🧠 Complexities
 * • Time Complexity (worst-case) : exponential — O(4^(n·m))  
 *   (every cell can branch to as many as four smaller neighbours).  
 * • Space Complexity : O(n × m) — recursion stack depth in the worst case.
 *
 * 🧪 Sample Input
 * 3
 * 3
 * 9 6 3
 * 8 7 2
 * 5 4 1
 * 0
 * 0
 * 2
 * 2
 *
 * 🧾 Sample Output
 * 5
 *
 * Explanation: There are five strictly-decreasing paths from (0,0)=9
 * to (2,2)=1 in the grid shown above.
 ******************************************************************************/

import java.util.*;

public class DecreasingPathCounter {

    /**
     * Recursively counts all strictly-decreasing paths from (x, y) to (dr, dc).
     */
    public static int count(int n, int m, int[][] a,
                            int x, int y, int dr, int dc) {

        // Base case: reached destination cell
        if (x == dr && y == dc) return 1;

        int paths = 0;

        // Direction vectors:  right,  left,   down,   up
        int[] dx     = { 0,   0,    1,  -1};
        int[] dy     = { 1,  -1,    0,   0};

        // Explore all 4 neighbours
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // Move only if inside bounds and value is strictly smaller
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] < a[x][y]) {
                paths += count(n, m, a, nx, ny, dr, dc);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid dimensions
        System.out.print("Enter n (rows): ");
        int n = sc.nextInt();
        System.out.print("Enter m (columns): ");
        int m = sc.nextInt();

        // Read matrix values
        System.out.println("Enter matrix elements:");
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        // Read source and destination coordinates
        System.out.print("Enter source row (sr): ");
        int sr = sc.nextInt();
        System.out.print("Enter source column (sc): ");
        int scCol = sc.nextInt();
        System.out.print("Enter destination row (dr): ");
        int dr = sc.nextInt();
        System.out.print("Enter destination column (dc): ");
        int dc = sc.nextInt();

        // Compute and print result
        int result = count(n, m, a, sr, scCol, dr, dc);
        System.out.println("Number of strictly decreasing paths: " + result);
    }
}
