class Day218 {
    class NumberInfo {
        int value;
        int listIndex;
        int numberIndex;
        NumberInfo(int value, int listIndex, int numberIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.numberIndex = numberIndex;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<NumberInfo> minHeap = new PriorityQueue<>((first, second) -> first.value - second.value);
        int currentMaximum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new NumberInfo(value, i, 0));
            if (value > currentMaximum) currentMaximum = value;
        }
        int bestStart = minHeap.peek().value;
        int bestEnd = currentMaximum;
        while (minHeap.size() == nums.size()) {
            NumberInfo smallestNumber = minHeap.poll();
            int currentMinimum = smallestNumber.value;
            if (currentMaximum - currentMinimum < bestEnd - bestStart) {
                bestStart = currentMinimum;
                bestEnd = currentMaximum;
            }
            int nextIndex = smallestNumber.numberIndex + 1;
            int listIndex = smallestNumber.listIndex;
            if (nextIndex == nums.get(listIndex).size()) break;
            int nextValue = nums.get(listIndex).get(nextIndex);
            minHeap.offer(new NumberInfo(nextValue, listIndex, nextIndex));
            if (nextValue > currentMaximum) currentMaximum = nextValue;
        }
        return new int[]{bestStart, bestEnd};
    }
}