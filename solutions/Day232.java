class Day232 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowers = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int left = (i == 0) ? 0 : flowerbed[i - 1];
                int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    flowers++;
                    if (flowers >= n) return true;
                }
            }
        }
        return flowers >= n;
    }
}