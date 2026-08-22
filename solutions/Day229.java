class Day229 {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> sums = new ArrayList<>();
        for (int value : mat[0])
            sums.add(value);
        for (int i = 1; i < mat.length; i++)
            sums = merge(sums, mat[i], k);
        return sums.get(k - 1);
    }
    private List<Integer> merge(List<Integer> sums, int[] row, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                sums.get(a[0]) + row[a[1]],
                sums.get(b[0]) + row[b[1]]
            )
        );
        for (int i = 0; i < Math.min(sums.size(), k); i++)
            minHeap.offer(new int[]{i, 0});
        List<Integer> result = new ArrayList<>();
        while (result.size() < k && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int sumIndex = pair[0];
            int rowIndex = pair[1];
            result.add(sums.get(sumIndex) + row[rowIndex]);
            if (rowIndex + 1 < row.length) minHeap.offer(new int[]{sumIndex, rowIndex + 1});
        }
        return result;
    }
}