class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> devices = new ArrayList<>();

        for (String b: bank) {
            int devicesInRow = 0;

            for (char c: b.toCharArray()) {
                if (c == '1') {
                    devicesInRow++;
                }
            }

            if (devicesInRow > 0) {
                devices.add(devicesInRow);
            }
        }

        int laserBeams = 0;
        for (int i = 0; i < devices.size() - 1; i++) {
            laserBeams += (devices.get(i) * devices.get(i+1));
        }

        return laserBeams;
    }
}