import java.util.*;
class Day69 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);
        int k = p.length();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = new String(subArr);
            if (sortedSub.equals(sortedP)) {
                result.add(i);
            }
        }
        return result;
    }
}