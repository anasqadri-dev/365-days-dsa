public class Day222 {
    static final long MOD = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i < n; i++)
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        sortEngineers(engineers);
        MinHeap minHeap = new MinHeap(k);
        long totalSpeed = 0;
        long bestPerformance = 0;
        for (int i = 0; i < n; i++) {
            totalSpeed += engineers[i].speed;
            minHeap.add(engineers[i].speed);
            if (minHeap.size > k) totalSpeed -= minHeap.removeMin();
            long performance = totalSpeed * engineers[i].efficiency;
            if (performance > bestPerformance) bestPerformance = performance;
        }
        return (int) (bestPerformance % MOD);
    }
    static class Engineer {
        int speed;
        int efficiency;
        Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    private void sortEngineers(Engineer[] engineers) {
        for (int i = 0; i < engineers.length - 1; i++) {
            for (int j = 0; j < engineers.length - i - 1; j++) {
                if (engineers[j].efficiency < engineers[j + 1].efficiency) {
                    Engineer temp = engineers[j];
                    engineers[j] = engineers[j + 1];
                    engineers[j + 1] = temp;
                }
            }
        }
    }
    static class MinHeap {
        int[] heap;
        int size;
        MinHeap(int capacity) {
            heap = new int[capacity + 1];
            size = 0;
        }
        void add(int value) {
            heap[size] = value;
            int current = size;
            size++;
            while (current > 0) {
                int parent = (current - 1) / 2;
                if (heap[parent] <= heap[current]) break;
                int temp = heap[parent];
                heap[parent] = heap[current];
                heap[current] = temp;
                current = parent;
            }
        }
        int removeMin() {
            int minimum = heap[0];
            heap[0] = heap[size - 1];
            size--;
            int current = 0;
            while (true) {
                int leftChild = current * 2 + 1;
                int rightChild = current * 2 + 2;
                int smallest = current;
                if (leftChild < size && heap[leftChild] < heap[smallest]) smallest = leftChild;
                if (rightChild < size && heap[rightChild] < heap[smallest]) smallest = rightChild;
                if (smallest == current) break;
                int temp = heap[current];
                heap[current] = heap[smallest];
                heap[smallest] = temp;
                current = smallest;
            }
            return minimum;
        }
    }
}