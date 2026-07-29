class Day209 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            maxHeap.offer(stone);
        while (maxHeap.size() > 1) {
            int heaviestStone = maxHeap.poll();
            int secondHeaviestStone = maxHeap.poll();
            if (heaviestStone != secondHeaviestStone)
                maxHeap.offer(heaviestStone - secondHeaviestStone);
        }
        if (maxHeap.isEmpty()) return 0;
        return maxHeap.peek();
    }
}