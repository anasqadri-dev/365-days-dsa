class Day88 {
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0;
        double high = stations[stations.length - 1] - stations[0];
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (isPossible(stations, k, mid))
                high = mid;
            else
                low = mid;
        }
        return high;
    }
    private boolean isPossible(int[] stations, int k, double maxDist) {
        int stationsNeeded = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            stationsNeeded += (int)(gap / maxDist);
        }
        return stationsNeeded <= k;
    }
}