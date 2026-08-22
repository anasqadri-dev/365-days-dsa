class Day227 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long) arr[a[0]] * arr[b[1]],
                (long) arr[b[0]] * arr[a[1]]
            )
        );
        for (int j = 1; j < n; j++)
            minHeap.offer(new int[]{0, j});
        for (int count = 1; count < k; count++) {
            int[] fraction = minHeap.poll();
            int numeratorIndex = fraction[0];
            int denominatorIndex = fraction[1];
            if (numeratorIndex + 1 < denominatorIndex) {
                minHeap.offer(new int[]{
                    numeratorIndex + 1,
                    denominatorIndex
                });
            }
        }
        int[] result = minHeap.poll();
        return new int[]{
            arr[result[0]],
            arr[result[1]]
        };
    }
}