class Day219 {
    static class CharacterInfo {
        char character;
        int frequency;
        CharacterInfo(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
    static class MaxHeap {
        CharacterInfo[] heap;
        int size;
        MaxHeap(int capacity) {
            heap = new CharacterInfo[capacity];
            size = 0;
        }
        void add(CharacterInfo characterInfo) {
            heap[size] = characterInfo;
            int currentIndex = size;
            size++;
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (heap[parentIndex].frequency >= heap[currentIndex].frequency) break;
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
                    if (leftChild < size && heap[leftChild].frequency > heap[largestIndex].frequency)
                        largestIndex = leftChild;
                    if (rightChild < size && heap[rightChild].frequency > heap[largestIndex].frequency)
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
    public String reorganizeString(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++)
            frequency[s.charAt(i) - 'a']++;
        MaxHeap maxHeap = new MaxHeap(26);
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                maxHeap.add(new CharacterInfo((char) ('a' + i),frequency[i]));
            }
        }
        StringBuilder answer = new StringBuilder();
        CharacterInfo previousCharacter = null;
        while (!maxHeap.isEmpty()) {
            CharacterInfo currentCharacter = maxHeap.remove();
            answer.append(currentCharacter.character);
            currentCharacter.frequency--;
            if (previousCharacter != null && previousCharacter.frequency > 0)
                maxHeap.add(previousCharacter);
            previousCharacter = currentCharacter;
        }
        if (answer.length() != s.length()) return "";
        return answer.toString();
    }
}