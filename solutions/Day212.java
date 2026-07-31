public class Day212 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            frequencyMap.put(currentCharacter, frequencyMap.getOrDefault(currentCharacter, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((firstCharacter, secondCharacter) -> frequencyMap.get(secondCharacter) - frequencyMap.get(firstCharacter));
        for (char currentCharacter : frequencyMap.keySet())
            maxHeap.offer(currentCharacter);
        StringBuilder answer = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char currentCharacter = maxHeap.poll();
            int frequency = frequencyMap.get(currentCharacter);
            for (int i = 0; i < frequency; i++)
                answer.append(currentCharacter);
        }
        return answer.toString();
    }
}