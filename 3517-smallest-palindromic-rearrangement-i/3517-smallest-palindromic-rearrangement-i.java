class Solution {
    public String smallestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        
        int half = s.length() / 2; 

        char[] arr = new char[half];

        for (int i = 0; i < half; i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr);

        StringBuilder firstHalf = new StringBuilder();

        for (char c : arr) {
            firstHalf.append(c);
        }

        StringBuilder lastHalf = new StringBuilder(firstHalf).reverse();

        StringBuilder res = new StringBuilder();
    
        if (s.length() % 2 != 0) {
            res.append(firstHalf);
            res.append(s.charAt(half));
            res.append(lastHalf);
            
        } else {
            res.append(firstHalf);
            res.append(lastHalf);
        }

        return res.toString();
    }
}