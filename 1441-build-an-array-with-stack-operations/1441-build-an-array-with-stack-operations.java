class Solution {
    public List<String> buildArray(int[] target, int n) {
        Set<Integer> map = new HashSet<>();
        for (int i : target) {
            map.add(i);
        }
        
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= target[target.length - 1]; i++) {
            res.add("Push");
            
            if (!map.contains(i)) {
                res.add("Pop");
            }   
        }
        
        return res;
    }
}