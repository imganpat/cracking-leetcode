class Solution {
    int max = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>());
        return max;    
    }

    public void backtrack(String s, int index, Set<String> set) {
        if (index == s.length()) {
            max = Math.max(set.size(), max);
            return;
        }

        for (int end = index; end < s.length(); end++) {
            String curr = s.substring(index, end + 1);

            if (set.contains(curr)) {
                continue;
            }

            set.add(curr);
            backtrack(s, end + 1, set);
            set.remove(curr);
        }
    }
}