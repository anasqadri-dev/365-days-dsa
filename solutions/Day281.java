public class Day281 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return result;
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] letters = word.toCharArray();
                for (int j = 0; j < letters.length; j++) {
                    char original = letters[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        letters[j] = ch;
                        String next = new String(letters);
                        if (words.contains(next) && !visited.contains(next)) {
                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            if (levelVisited.add(next)) queue.offer(next);
                            if (next.equals(endWord)) found = true;
                        }
                    }
                    letters[j] = original;
                }
            }
            visited.addAll(levelVisited);
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            buildPaths(beginWord, endWord, parents, path, result);
        }
        return result;
    }
    private void buildPaths(
            String beginWord, String word,
            Map<String, List<String>> parents,
            List<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }
        for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
            path.add(parent);
            buildPaths(beginWord, parent, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}