class Day211 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : nums)
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (firstNumber, secondNumber) -> frequencyMap.get(secondNumber) - frequencyMap.get(firstNumber));
        for (int number : frequencyMap.keySet())
            maxHeap.offer(number);
        int[] answer = new int[k];
        for (int i = 0; i < k; i++)
            answer[i] = maxHeap.poll();
        return answer;
    }
}