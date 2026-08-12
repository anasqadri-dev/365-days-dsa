public class Day223 {
    public int scheduleCourse(int[][] courses) {
        sortCourses(courses);
        MaxHeap maxHeap = new MaxHeap(courses.length);
        int totalDays = 0;
        for (int i = 0; i < courses.length; i++) {
            int duration = courses[i][0];
            int lastDay = courses[i][1];
            totalDays += duration;
            maxHeap.add(duration);
            if (totalDays > lastDay) totalDays -= maxHeap.removeMax();
        }
        return maxHeap.size;
    }
    private void sortCourses(int[][] courses) {
        for (int i = 0; i < courses.length - 1; i++) {
            for (int j = 0; j < courses.length - i - 1; j++) {
                if (courses[j][1] > courses[j + 1][1]) {
                    int[] temp = courses[j];
                    courses[j] = courses[j + 1];
                    courses[j + 1] = temp;
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