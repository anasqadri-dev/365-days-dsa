class Day210 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        PriorityQueue<String> maxHeap = new PriorityQueue<>((firstWord, secondWord) -> {
            int firstFrequency = wordCount.get(firstWord);
            int secondFrequency = wordCount.get(secondWord);
            if (firstFrequency != secondFrequency) return secondFrequency - firstFrequency;
            return firstWord.compareTo(secondWord);
        });
        for (String word : wordCount.keySet())
            maxHeap.offer(word);
        List<String> answer = new ArrayList<>();
        while (k > 0) {
            answer.add(maxHeap.poll());
            k--;
        }
        return answer;
    }
}