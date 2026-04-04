class Solution {
    private String generate(String curr, int n, Set<String> set) {
        if (curr.length() == n) {
            if (!set.contains(curr)) {
                return curr;
            }
            return null;
        }

        String res = generate(curr + "0", n, set);
        if (res != null) {
            return res;
        }

        res = generate(curr + "1", n, set);
        return res;
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String s : nums) {
            set.add(s);
        }

        return generate("", nums.length, set);
    }
}