class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare((a[0] - a[1]), (b[0] - b[1])));
        int totalCost = 0;
        int n = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            if (i < n) {
                totalCost += costs[i][0];
            } else {
                totalCost += costs[i][1];
            }
        }
        return totalCost;
    }
}