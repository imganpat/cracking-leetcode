class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int pile: piles){
            r = Math.max(pile, r);
        }

        int res = r;

        while(l <= r){
            int m = l + (r - l) / 2;
            long hours = 0;
            
            for(int pile: piles){
                hours += pile / m;

                if(pile % m != 0){
                    hours++;
                }
            }

            if(hours <= h){
                res = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return res;
    }
}