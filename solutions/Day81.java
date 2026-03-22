public class Day81 {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int firstIndex = 0; firstIndex < length - 2; firstIndex++) {
            if (firstIndex > 0 && numbers[firstIndex] == numbers[firstIndex - 1])
                continue;
            int leftPointer = firstIndex + 1;
            int rightPointer = length - 1;
            while (leftPointer < rightPointer) {
                int currentSum = numbers[firstIndex] 
                               + numbers[leftPointer] 
                               + numbers[rightPointer];
                if (currentSum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numbers[firstIndex]);
                    triplet.add(numbers[leftPointer]);
                    triplet.add(numbers[rightPointer]);
                    answer.add(triplet);
                    leftPointer++;
                    rightPointer--;
                    while (leftPointer < rightPointer && numbers[leftPointer] == numbers[leftPointer - 1])
                        leftPointer++;
                    while (leftPointer < rightPointer && numbers[rightPointer] == numbers[rightPointer + 1])
                        rightPointer--;
                }
                else if (currentSum < 0)
                    leftPointer++;
                else
                    rightPointer--;
            }
        }
        return answer;
    }
}