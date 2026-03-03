class Day62 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        addCharacters(s, count);
        removeCharacters(t, count);
        return checkZero(count);
    }
    public void addCharacters(String str, int[] count) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch - 'a']++;
        }
    }
    public void removeCharacters(String str, int[] count) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch - 'a']--;
        }
    }
    public boolean checkZero(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}