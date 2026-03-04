class Day63 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (!isLengthValid(ransomNote, magazine))
            return false;
        int[] frequency = buildFrequency(magazine);
        return canUseLetters(ransomNote, frequency);
    }

    public boolean isLengthValid(String ransomNote, String magazine) {
        return ransomNote.length() <= magazine.length();
    }

    public int[] buildFrequency(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            count[ch - 'a']++;
        }
        return count;
    }

    public boolean canUseLetters(String ransomNote, int[] count) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }
        return true;
    }
}