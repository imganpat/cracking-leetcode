class Solution {
    Set<String> map;
    public String backtrack(String[] nums, StringBuilder curr, int i){
        if(i == nums.length){
            if(!map.contains(curr.toString())) {
                return curr.toString();
            }
            return null;
        }

        String res = backtrack(nums, new StringBuilder(curr + "0"), i+1);
        if(res != null){
            return res;
        }
        
        res = backtrack(nums, new StringBuilder(curr + "1"), i+1);
        if(res != null){
            return res;
        }

        return null;

    }
    
    public String findDifferentBinaryString(String[] nums) {
        // StringBuilder res = new StringBuilder();
        // for(int i = 0; i < nums.length; i++){
        //     char c = nums[i].charAt(i);
        //     res.append(c == '0' ? '1' : '0');
        // }
        // return res.toString();

        map = new HashSet();

        for(String s: nums){
            map.add(s);
        }

        return backtrack(nums, new StringBuilder(), 0);
    }
}