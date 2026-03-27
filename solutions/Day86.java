class Day86 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int bananas : piles)
            right = Math.max(right, bananas);
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hoursNeeded = 0;
            for (int pile : piles)
                hoursNeeded += (pile + mid - 1) / mid;
            if (hoursNeeded <= h) {
                answer = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return answer;
    }
}