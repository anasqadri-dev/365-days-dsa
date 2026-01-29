class Day29 {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0] - 1950;
            int death = logs[i][1] - 1950;
            year[birth]++;
            year[death]--;
        }
        int maxPopulation = 0;
        int currentPopulation = 0;
        int answerYear = 1950;
        for (int i = 0; i < 101; i++) {
            currentPopulation += year[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answerYear = i + 1950;
            }
        }
        return answerYear;
    }
}