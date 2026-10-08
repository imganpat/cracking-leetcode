class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] garbageCount = new int[3];
        int lastM = 0;
        int lastP = 0;
        int lastG = 0;
        
        for (int i = 0; i < garbage.length; i++)  {
            for  (char c: garbage[i].toCharArray()) {
                if (c == 'M'){
                    garbageCount[0]++;
                    lastM = i;
                } else if (c == 'P'){
                    garbageCount[1]++;
                    lastP = i;
                } else{
                    garbageCount[2]++;
                    lastG = i;
                }
            }
        }

        int[] prefix = new int[travel.length  + 1];
        prefix[0] = 0;
        for (int i = 0; i < travel.length; i++) {
            prefix[i + 1] = prefix[i] + travel[i]; 
        }

        return prefix[lastM] + prefix[lastP] + prefix[lastG] + garbageCount[0] + garbageCount[1] + garbageCount[2];

    }
}