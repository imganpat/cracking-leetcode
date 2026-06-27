class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int num: nums) {
            long current = num;

            while (!stack.isEmpty() && stack.peek() == current) {
                current += stack.pop();
            }
            
            stack.push(current);
        }

        List<Long> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        Collections.reverse(res);

        return res;
    }
}