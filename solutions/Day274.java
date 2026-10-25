public class Day274 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String code : deadends) dead.add(code);
        if (dead.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");
        int turns = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return turns;
                for (int j = 0; j < 4; j++) {
                    char[] digits = current.toCharArray();
                    digits[j] = (char) ('0' + (digits[j] - '0' + 1) % 10);
                    String next = new String(digits);
                    if (!dead.contains(next) && visited.add(next)) queue.add(next);
                    digits[j] = (char) ('0' + (digits[j] - '0' + 8) % 10);
                    next = new String(digits);
                    if (!dead.contains(next) && visited.add(next)) queue.add(next);
                }
            }
            turns++;
        }
        return -1;
    }
}