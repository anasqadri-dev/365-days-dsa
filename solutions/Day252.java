class Day252 {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char ch : s.toCharArray()) {
            result ^= ch;
        }
        for (char ch : t.toCharArray()) {
            result ^= ch;
        }
        return result;
    }
}