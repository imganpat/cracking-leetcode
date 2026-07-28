// Approach: Sort the First Half
// 1. Since the given string is already a palindrome,
//    the first half completely determines the second half.
// 2. Extract the first half of the palindrome.
// 3. Sort the first half in ascending order.
// 4. Build the smallest lexicographical palindrome by:
//      - Using the sorted first half.
//      - Keeping the middle character unchanged (if the length is odd).
//      - Appending the reverse of the sorted first half.
// 5. Return the constructed palindrome.
//
// Time complexity: O((n/2) log(n/2))
//   - Sorting the first half dominates
// Space complexity: O(n)
//   - Character array and result builders

class Solution {
    public String smallestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        int half = s.length() / 2;

        // Extract the first half
        char[] arr = new char[half];

        for (int i = 0; i < half; i++) {
            arr[i] = s.charAt(i);
        }

        // Sort to obtain the smallest lexicographical order
        Arrays.sort(arr);

        StringBuilder firstHalf = new StringBuilder();

        for (char c : arr) {
            firstHalf.append(c);
        }

        // Mirror the first half
        StringBuilder lastHalf = new StringBuilder(firstHalf).reverse();

        StringBuilder res = new StringBuilder();

        if (s.length() % 2 != 0) {
            res.append(firstHalf);
            res.append(s.charAt(half));
            res.append(lastHalf);

        } else {
            res.append(firstHalf);
            res.append(lastHalf);
        }

        return res.toString();
    }
}