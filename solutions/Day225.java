class Day225 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) continue;
            minHeap.offer(climb);
            if (minHeap.size() > ladders) bricks -= minHeap.poll();
            if (bricks < 0) return i;
        }
        return heights.length - 1;
    }
}