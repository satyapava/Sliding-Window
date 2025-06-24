// --------------------------------------------------------------
// 🔹 Count of Distinct Substrings Having All Distinct Characters
// --------------------------------------------------------------

/*
✅ Description:
Given a string 's', count how many distinct substrings can be formed 
such that all characters in each substring are unique (no repetitions).

🧠 Approach:
- For each starting character in the string, try to extend the substring 
  as far as all characters remain distinct.
- Use a HashSet to store only unique substrings.
*/

import java.util.*;

public class CountAllDisSubStrings {

    /*
    Function to count all distinct substrings with unique characters
    */
    public static int countUniqueDistinctCharSubstrings(String s) {
        Set<String> uniqueSubstrings = new HashSet<>(); // Stores all valid unique substrings
        int n = s.length();

        // Loop through all starting points of substrings
        for (int i = 0; i < n; i++) {
            Set<Character> charSet = new HashSet<>(); // Keeps track of characters seen in current substring
            StringBuilder sb = new StringBuilder();

            // Loop to build substrings from index i
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);

                // If character is repeated, break the loop
                if (charSet.contains(c)) break;

                // Add character to current substring
                sb.append(c);
                charSet.add(c);

                // Store in HashSet to ensure uniqueness
                uniqueSubstrings.add(sb.toString());
            }
        }

        // Return total number of unique substrings with distinct characters
        return uniqueSubstrings.size();
    }

    /*
    Main method to take input and print the result
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 📥 Input
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        // Call the function and get result
        int result = countUniqueDistinctCharSubstrings(s);

        // 📤 Output
        System.out.println("Total distinct substrings with all distinct characters: " + result);
    }
}

/*
--------------------------------------------------------------
🔢 Time and Space Complexity Analysis:
--------------------------------------------------------------
Time Complexity  : O(n^2)  -> For generating all substrings
Space Complexity : O(n^2)  -> For storing substrings in the HashSet

📥 Sample Input:
abca

📤 Sample Output:
Total distinct substrings with all distinct characters: 9
--------------------------------------------------------------
*/
