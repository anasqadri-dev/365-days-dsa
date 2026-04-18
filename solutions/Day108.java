class Day108 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int max_ans = 0;
        int[] count = new int[100001];
        int types = 0;
        for (int right = 0; right < fruits.length; right++) {
            int curr_fruit = fruits[right];
            if (count[curr_fruit] == 0)
                types++;
            count[curr_fruit]++;
            while (types > 2) {
                int left_fruit = fruits[left];
                count[left_fruit]--;
                if (count[left_fruit] == 0)
                    types--;
                left++;
            }
            int window_size = right - left + 1;
            max_ans = Math.max(max_ans, window_size);
        }
        return max_ans;
    }
}