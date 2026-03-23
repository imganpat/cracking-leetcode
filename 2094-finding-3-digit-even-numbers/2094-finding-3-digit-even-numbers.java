// Approach: Brute Force (100–999) + Frequency Check
// 1. Count the frequency of each digit (0–9) from the input array.
// 2. Iterate through all 3-digit numbers from 100 to 999.
// 3. For each number:
//    - Check if it is even (last digit must be even).
//    - Count the digits of the number and compare with the available frequency.
//    - If any digit is used more times than available, reject the number.
// 4. If valid, add the number to the result list.
// 5. Convert the list to an array and return.
//
// Time complexity: O(900 * d)
//   - 900 numbers checked (100–999)
//   - d = number of digits per number (constant = 3)
//   - Effectively O(1) since range is fixed
// Space complexity: O(1)
//   - Frequency array of size 10 + temporary array of size 10

class Solution {

    // Helper: checks if number can be formed using available digits
    public boolean isEven(int n, int[] freq) {
        int[] temp = new int[10];

        // Last digit must be even
        if ((n % 10) % 2 != 0)
            return false;

        // Count digits of n and compare with freq
        while (n > 0) {
            int d = n % 10;
            temp[d]++;

            // If using more than available → invalid
            if (temp[d] > freq[d]) {
                return false;
            }

            n /= 10;
        }

        return true;
    }

    public int[] findEvenNumbers(int[] digits) {

        // Step 1: Count frequency of input digits
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        List<Integer> list = new ArrayList<>();

        // Step 2: Check all 3-digit numbers
        for (int i = 100; i < 1000; i++) {
            if (isEven(i, freq)) {
                list.add(i);
            }
        }

        // Step 3: Convert list to array
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}