class Solution {
    public String maxValue(String n, int x) {
        StringBuilder res = new StringBuilder();
        boolean isNegative = (n.charAt(0) == '-') ? true : false;
        char digit = (char) (x + '0');
        boolean inserted = false;

        if(isNegative) {
            res.append("-");
            
            for(int i = 1; i < n.length(); i++) {
                if(!inserted && n.charAt(i) > digit) {
                    res.append(digit);
                    inserted = true;
                }

                res.append(n.charAt(i));
            }

        } else {
            
            for (int i = 0; i < n.length(); i++) {
                if(!inserted && n.charAt(i) < digit) {
                    res.append(digit);
                    inserted = true;
                }
                
                res.append(n.charAt(i));
            }

        }

        if (!inserted) {
            res.append(digit);
        }

        return res.toString();
    }
}