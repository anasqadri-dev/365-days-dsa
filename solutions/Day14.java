public class Day14 {
    public int maximumWealth(int[][] accounts) {
        int sum[] = new int[accounts.length];
        int greatest = sum[0];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum[i] = sum[i] + accounts[i][j];
            }
            if (sum[i] > greatest)
                greatest = sum[i];
        }
        return greatest;
    }
}
