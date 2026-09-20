// Approach: Iterate over the string, and for each character:
    // 1. Convert it into a "reverse weight" by doing ('z' + 1 - char).
    // 2. Multiply that weight by its (1-based) position index.
    // 3. Accumulate into reverseDegree and return the total.
// Time complexity: O(n) 
// Space complexity: O(1) 

class Solution {
    public int reverseDegree(String s) {
        int reverseDegree = 0;
        for(int i = 0; i < s.length(); i++){
            reverseDegree += ('z' + 1  - s.charAt(i)) * (i + 1); 
        }
        return reverseDegree;
    }
}