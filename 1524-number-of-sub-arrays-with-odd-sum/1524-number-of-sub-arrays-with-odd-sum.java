class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long count =  0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        for(int n: arr){
            sum += n;

            int rem = sum % 2;

            int opp = 1 - rem;

            if(map.containsKey(opp)){
                count += map.get(opp);
            }
            count %= MOD;

            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        return (int) count;
    }
}