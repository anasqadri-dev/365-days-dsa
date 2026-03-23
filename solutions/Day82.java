class Day82 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> answer = new ArrayList<>();
        int length = numbers.length;
        for (int firstIndex = 0; firstIndex < length - 3; firstIndex++) {
            if (firstIndex > 0 && numbers[firstIndex] == numbers[firstIndex - 1])
                continue;
            for (int secondIndex = firstIndex + 1; secondIndex < length - 2; secondIndex++) {
                if (secondIndex > firstIndex + 1 && numbers[secondIndex] == numbers[secondIndex - 1])
                    continue;
                int leftPointer = secondIndex + 1;
                int rightPointer = length - 1;
                while (leftPointer < rightPointer) {
                    long currentSum = (long)numbers[firstIndex] 
                                    + numbers[secondIndex]
                                    + numbers[leftPointer]
                                    + numbers[rightPointer];
                    if (currentSum == target) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(numbers[firstIndex]);
                        quadruplet.add(numbers[secondIndex]);
                        quadruplet.add(numbers[leftPointer]);
                        quadruplet.add(numbers[rightPointer]);
                        answer.add(quadruplet);
                        leftPointer++;
                        rightPointer--;
                        while (leftPointer < rightPointer && numbers[leftPointer] == numbers[leftPointer - 1])
                            leftPointer++;
                        while (leftPointer < rightPointer && numbers[rightPointer] == numbers[rightPointer + 1])
                            rightPointer--;
                    } 
                    else if (currentSum < target)
                        leftPointer++;
                    else
                        rightPointer--;
                }
            }
        }
        return answer;
    }
}