public class Day221 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(
                quality[i],
                wage[i],
                (double) wage[i] / quality[i]
            );
        }
        sortWorkers(workers);
        MaxHeap maxHeap = new MaxHeap(k);
        int totalQuality = 0;
        double answer = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            totalQuality += workers[i].quality;
            maxHeap.add(workers[i].quality);
            if (maxHeap.size == k) {
                double currentCost = totalQuality * workers[i].ratio;
                answer = Math.min(answer, currentCost);
                totalQuality -= maxHeap.removeMax();
            }
        }
        return answer;
    }
    static class Worker {
        int quality;
        int wage;
        double ratio;
        Worker(int quality, int wage, double ratio) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = ratio;
        }
    }
    private void sortWorkers(Worker[] workers) {
        for (int i = 0; i < workers.length - 1; i++) {
            for (int j = 0; j < workers.length - i - 1; j++) {
                if (workers[j].ratio > workers[j + 1].ratio) {
                    Worker temp = workers[j];
                    workers[j] = workers[j + 1];
                    workers[j + 1] = temp;
                }
            }
        }
    }
    static class MaxHeap {
        int[] heap;
        int size;
        MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }
        void add(int value) {
            heap[size] = value;
            int current = size;
            size++;
            while (current > 0) {
                int parent = (current - 1) / 2;
                if (heap[parent] >= heap[current]) break;
                int temp = heap[parent];
                heap[parent] = heap[current];
                heap[current] = temp;
                current = parent;
            }
        }
        int removeMax() {
            int maxValue = heap[0];
            heap[0] = heap[size - 1];
            size--;
            int current = 0;
            while (true) {
                int leftChild = current * 2 + 1;
                int rightChild = current * 2 + 2;
                int largest = current;
                if (leftChild < size && heap[leftChild] > heap[largest])
                    largest = leftChild;
                if (rightChild < size && heap[rightChild] > heap[largest])
                    largest = rightChild;
                if (largest == current) break;
                int temp = heap[current];
                heap[current] = heap[largest];
                heap[largest] = temp;
                current = largest;
            }
            return maxValue;
        }
    }
}