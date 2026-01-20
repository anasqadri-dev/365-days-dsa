class Day20 {
    public boolean checkIfPangram(String sentence) {
        boolean seen[] = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            int index = sentence.charAt(i) - 'a';
            seen[index] = true;
        }
        for (boolean b : seen) {
            if (!b)
                return false;
        }
        return true;
    }
}