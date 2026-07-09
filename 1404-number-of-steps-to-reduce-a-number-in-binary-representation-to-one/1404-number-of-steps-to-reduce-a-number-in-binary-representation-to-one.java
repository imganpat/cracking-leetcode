// Approach: Binary Simulation with Carry
// 1. We need to reduce the binary number to 1 using:
//      - If even: divide by 2.
//      - If odd : add 1, then divide by 2.
// 2. Instead of modifying the binary string,
//    simulate the process from the least significant bit.
// 3. Maintain a carry representing whether a previous
//    addition has propagated to the current bit.
// 4. For each bit (right to left, excluding the MSB):
//      bit = currentBit + carry
//
//    Case 1: bit == 0 or bit == 2
//      - Number is effectively even.
//      - One divide-by-2 operation.
//      - steps += 1
//
//    Case 2: bit == 1
//      - Number is odd.
//      - One add-1 and one divide-by-2.
//      - steps += 2
//      - carry = 1
//
// 5. After processing all remaining bits,
//    if carry is still 1, one extra step is needed.
// 6. Return total steps.
//
// Time complexity: O(n)
//   - Single traversal of the string
// Space complexity: O(1)

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Process from LSB to MSB
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            // Odd
            if (bit == 1) {
                // +1 then /2
                steps += 2;
                carry = 1;
            }

            // Even
            else {
                // Only /2
                steps++;
            }
        }

        // Extra carry at MSB
        return steps + carry;
    }
}