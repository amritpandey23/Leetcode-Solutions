class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int out = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            if (boxTypes[i][0] < truckSize) {
                truckSize -= boxTypes[i][0];
                out += boxTypes[i][0] * boxTypes[i][1];
            } else {
                out += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        return out;
    }
}