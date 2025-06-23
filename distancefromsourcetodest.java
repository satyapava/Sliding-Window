
/******************************************************************************
 * 📍 Problem: Count Paths from Source to Destination with Strictly Decreasing Values
 *
 * 📝 Description:
 * Given a 2D grid of integers, count the number of ways to reach a destination
 * cell (dr, dc) from a source cell (sr, sc) by only moving to adjacent cells
 * with strictly lower values.
 *
 * 🔧 Approach:
 * - Breadth-First Search (BFS) using a queue to explore valid paths.
 * - Only move to a neighboring cell if its value is strictly less than the
 *   current cell.
 * - Count how many times the destination is reached following this rule.
 *
 * 🧠 Time Complexity: O(N * M)
 * 🚀 Space Complexity: O(N * M)
 *
 * 📥 Input Format:
 * - n (rows), m (columns)
 * - 2D array of size n x m
 * - sr, sc (source row & column), dr, dc (destination row & column)
 *
 * 📤 Output:
 * - Total number of valid strictly-decreasing paths from (sr, sc) to (dr, dc)
 ******************************************************************************/

import java.util.*;

class distancefromsourcetodest 
{
    public static int count(int n, int m, int[][] a, int sr, int sc, int dr, int dc)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc}); // Start BFS from source cell

        int ans = 0;
        int[] r = {0, 0, 1, -1}; // Row directions: right, left, down, up
        int[] c = {1, -1, 0, 0}; // Column directions: right, left, down, up

        while (!q.isEmpty())
        {
            int[] p = q.poll();
            int a1 = p[0]; // Current row
            int a2 = p[1]; // Current column

            // Explore all 4 directions
            for (int i = 0; i < 4; i++)
            {
                int x = a1 + r[i];
                int y = a2 + c[i];

                // Check bounds and value condition
                if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] < a[a1][a2])
                {
                    q.add(new int[]{x, y}); // Valid move
                    if (x == dr && y == dc)
                        ans++; // Reached destination
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);

        // Input: dimensions of the grid
        System.out.println("Enter n:");
        int n = s.nextInt();
        System.out.println("Enter m:");
        int m = s.nextInt();

        // Input: grid values
        System.out.println("Enter array elements:");
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                a[i][j] = s.nextInt();
            }
        }

        // Input: source and destination coordinates
        System.out.println("Enter sr:");
        int sr = s.nextInt();
        System.out.println("Enter sc:");
        int sc = s.nextInt();
        System.out.println("Enter dr:");
        int dr = s.nextInt();
        System.out.println("Enter dc:");
        int dc = s.nextInt();

        // Call count function and print the result
        int ans = count(n, m, a, sr, sc, dr, dc);
        System.out.println("The number of ways he can reach from source to destination: " + ans);
    }
}
