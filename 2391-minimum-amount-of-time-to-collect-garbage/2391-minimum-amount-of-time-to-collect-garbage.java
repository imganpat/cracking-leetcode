class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalGarbage = 0;
        int lastM = 0;
        int lastP = 0;
        int lastG = 0;
        
        for (int i = 0; i < garbage.length; i++)  {
            for  (char c: garbage[i].toCharArray()) {
                if (c == 'M'){
                    lastM = i;
                } else if (c == 'P'){
                    lastP = i;
                } else{
                    lastG = i;
                }
            }
            totalGarbage += garbage[i].length();
        }

        int[] prefix = new int[travel.length  + 1];
        
        prefix[0] = 0;
        
        for (int i = 0; i < travel.length; i++) {
            prefix[i + 1] = prefix[i] + travel[i]; 
        }

        return prefix[lastM] + prefix[lastP] + prefix[lastG] + totalGarbage;

    }
}