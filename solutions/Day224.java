public class Day224 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        MaxHeap maxHeap = new MaxHeap(stations.length);
        int currentPosition = 0;
        int currentFuel = startFuel;
        int stops = 0;
        for (int i = 0; i <= stations.length; i++) {
            int nextPosition;
            int fuelAtStation = 0;
            if (i == stations.length) {
                nextPosition = target;
            } else {
                nextPosition = stations[i][0];
                fuelAtStation = stations[i][1];
            }
            int distance = nextPosition - currentPosition;
            while (currentFuel < distance) {
                if (maxHeap.size == 0) return -1;
                currentFuel += maxHeap.removeMax();
                stops++;
            }
            currentFuel -= distance;
            currentPosition = nextPosition;
            if (i < stations.length) maxHeap.add(fuelAtStation);
        }
        return stops;
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
            int maximum = heap[0];
            heap[0] = heap[size - 1];
            size--;
            int current = 0;
            while (true) {
                int leftChild = current * 2 + 1;
                int rightChild = current * 2 + 2;
                int largest = current;
                if (leftChild < size && heap[leftChild] > heap[largest]) largest = leftChild;
                if (rightChild < size && heap[rightChild] > heap[largest]) largest = rightChild;
                if (largest == current) break;
                int temp = heap[current];
                heap[current] = heap[largest];
                heap[largest] = temp;
                current = largest;
            }
            return maximum;
        }
    }
}