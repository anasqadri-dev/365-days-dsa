class Day220 {
    static class CharacterInfo {
        char character;
        int count;
        CharacterInfo(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
    static class MaxHeap {
        CharacterInfo[] heap;
        int size;
        MaxHeap(int capacity) {
            heap = new CharacterInfo[capacity];
            size = 0;
        }
        void add(CharacterInfo character) {
            heap[size] = character;
            int currentIndex = size;
            size++;
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (heap[parentIndex].count >= heap[currentIndex].count) break;
                CharacterInfo temporary = heap[parentIndex];
                heap[parentIndex] = heap[currentIndex];
                heap[currentIndex] = temporary;
                currentIndex = parentIndex;
            }
        }
        CharacterInfo remove() {
            CharacterInfo maximum = heap[0];
            size--;
            if (size > 0) {
                heap[0] = heap[size];
                int currentIndex = 0;
                while (true) {
                    int leftChild = currentIndex * 2 + 1;
                    int rightChild = currentIndex * 2 + 2;
                    int largestIndex = currentIndex;
                    if (leftChild < size && heap[leftChild].count > heap[largestIndex].count)
                        largestIndex = leftChild;
                    if (rightChild < size && heap[rightChild].count > heap[largestIndex].count)
                        largestIndex = rightChild;
                    if (largestIndex == currentIndex) break;
                    CharacterInfo temporary = heap[currentIndex];
                    heap[currentIndex] = heap[largestIndex];
                    heap[largestIndex] = temporary;
                    currentIndex = largestIndex;
                }
            }
            return maximum;
        }
        boolean isEmpty() {return size == 0;}
    }
    public String longestDiverseString(int a, int b, int c) {
        MaxHeap maxHeap = new MaxHeap(3);
        if (a > 0) maxHeap.add(new CharacterInfo('a', a));
        if (b > 0) maxHeap.add(new CharacterInfo('b', b));
        if (c > 0) maxHeap.add(new CharacterInfo('c', c));
        StringBuilder answer = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharacterInfo first = maxHeap.remove();
            int length = answer.length();
            if (length >= 2 &&
                    answer.charAt(length - 1) == first.character &&
                    answer.charAt(length - 2) == first.character) {
                if (maxHeap.isEmpty()) break;
                CharacterInfo second = maxHeap.remove();
                answer.append(second.character);
                second.count--;
                if (second.count > 0) maxHeap.add(second);
                maxHeap.add(first);
            } else {
                answer.append(first.character);
                first.count--;
                if (first.count > 0) maxHeap.add(first);
            }
        }
        return answer.toString();
    }
}