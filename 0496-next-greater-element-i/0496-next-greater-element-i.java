class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int num : nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextGreater.get(nums1[i]);
        }

        return res;
    }
}