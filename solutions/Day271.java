public class Day271 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return length;
                char[] letters = word.toCharArray();
                for (int j = 0; j < letters.length; j++) {
                    char original = letters[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        letters[j] = ch;
                        String next = new String(letters);
                        if (words.contains(next)) {
                            queue.add(next);
                            words.remove(next);
                        }
                    }
                    letters[j] = original;
                }
            }
            length++;
        }
        return 0;
    }
}