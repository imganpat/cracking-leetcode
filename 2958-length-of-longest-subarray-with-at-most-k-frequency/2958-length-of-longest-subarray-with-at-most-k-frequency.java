// Approach: Variable-Size Sliding Window + HashMap
// 1. Maintain a window [start...end] where every number appears
//    at most k times.
// 2. Expand the window by moving end and increase the frequency
//    of nums[end].
// 3. If nums[end] appears more than k times, shrink the window
//    from the left until its frequency becomes valid again.
// 4. After the window becomes valid, update the maximum length.
// 5. Because the window only moves forward, every element is
//    added and removed at most once.
//
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < nums.length; end++) {
            int endElement = nums[end];

            // Add current element to the window
            map.put(
                    endElement,
                    map.getOrDefault(endElement, 0) + 1);

            // Shrink window if current element
            // appears more than k times
            while (map.get(endElement) > k) {
                int startElement = nums[start];
                map.put(
                        startElement,
                        map.get(startElement) - 1);

                if (map.get(startElement) == 0) {
                    map.remove(startElement);
                }

                start++;
            }

            // Current window is valid
            max = Math.max(
                    max,
                    end - start + 1);
        }

        return max;
    }
}