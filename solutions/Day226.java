class Day226 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            events.add(new int[]{left, -height});
            events.add(new int[]{right, height});
        }
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < events.size()) {
            int x = events.get(i)[0];
            while (i < events.size() && events.get(i)[0] == x) {
                int height = events.get(i)[1];
                if (height < 0) maxHeap.offer(-height);
                else maxHeap.remove(height);
                i++;
            }
            int currentHeight = maxHeap.peek();
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != currentHeight)
                result.add(Arrays.asList(x, currentHeight));
        }
        return result;
    }
}