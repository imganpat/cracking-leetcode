// Approach: Count Devices + Adjacent Non-Empty Rows
// 1. Traverse each row of the bank.
// 2. Count the number of security devices ('1') in that row.
// 3. Ignore rows with zero devices, since they do not contribute
//    to laser beams.
// 4. Store the device counts of all non-empty rows.
// 5. For every pair of consecutive non-empty rows:
//      beams = devicesInRow1 × devicesInRow2
// 6. Sum the beams for all such pairs.
// 7. Return the total number of laser beams.
//
// Time complexity: O(m × n)
//   - m = number of rows
//   - n = number of columns
// Space complexity: O(m)
//   - Stores device counts of non-empty rows

class Solution {

    public int numberOfBeams(String[] bank) {

        List<Integer> devices = new ArrayList<>();

        // Count devices in each non-empty row
        for (String row : bank) {

            int devicesInRow = 0;

            for (char c : row.toCharArray()) {

                if (c == '1') {
                    devicesInRow++;
                }
            }

            if (devicesInRow > 0) {
                devices.add(devicesInRow);
            }
        }

        // Compute beams between consecutive non-empty rows
        int laserBeams = 0;

        for (int i = 0; i < devices.size() - 1; i++) {

            laserBeams +=
                    devices.get(i) * devices.get(i + 1);
        }

        return laserBeams;
    }
}