class Day22 {
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
            if (altitude[i + 1] > max) max = altitude[i + 1];
        }
        return max;
    }
}