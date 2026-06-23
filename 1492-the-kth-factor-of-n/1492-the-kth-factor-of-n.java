// Approach: Factor Enumeration using Square Root
// 1. Factors always appear in pairs:
//      i × (n / i) = n
// 2. Iterate only up to √n.
// 3. For every divisor i:
//      - i is a factor.
//      - n / i is the paired factor.
// 4. Small factors are encountered in increasing order.
//    Check them immediately.
// 5. Store the larger paired factors.
// 6. Traverse the stored factors in reverse order
//    to obtain them in increasing order.
// 7. Return the k-th factor if found,
//    otherwise return -1.
//
// Time complexity: O(√n)
//   - Iterate only up to √n
// Space complexity: O(√n)
//   - Stores larger factors

class Solution {

    public int kthFactor(int n, int k) {

        List<Integer> factors = new ArrayList<>();

        // Enumerate factor pairs
        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                // Small factor
                if (--k == 0) {
                    return i;
                }

                // Store paired factor
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        // Process larger factors
        for (int i = factors.size() - 1; i >= 0; i--) {

            if (--k == 0) {
                return factors.get(i);
            }
        }

        return -1;
    }
}