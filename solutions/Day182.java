public class Day182 {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;
        for (int length : matchsticks)
            totalLength += length;
        if (totalLength % 4 != 0) return false;
        int sideLength = totalLength / 4;
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        return buildSquare(matchsticks, matchsticks.length - 1, sides, sideLength);
    }
    private boolean buildSquare(int[] matchsticks, int currentIndex, int[] sides, int sideLength) {
        if (currentIndex < 0) return true;
        int currentStick = matchsticks[currentIndex];
        for (int side = 0; side < 4; side++) {
            if (sides[side] + currentStick > sideLength) continue;
            sides[side] += currentStick;
            if (buildSquare(matchsticks, currentIndex - 1, sides, sideLength)) return true;
            sides[side] -= currentStick;
            if (sides[side] == 0) break;
        }
        return false;
    }
}