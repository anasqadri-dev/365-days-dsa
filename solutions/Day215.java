class Day215 {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char task : tasks)
            frequency[task - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (first, second) -> second - first
        );
        for (int count : frequency)
            if (count > 0) maxHeap.offer(count);
        int totalIntervals = 0;
        while (!maxHeap.isEmpty()) {
            int[] remainingTasks = new int[n + 1];
            int tasksDone = 0;
            while (tasksDone <= n && !maxHeap.isEmpty()) {
                int currentFrequency = maxHeap.poll();
                currentFrequency--;
                if (currentFrequency > 0) remainingTasks[tasksDone] = currentFrequency;
                totalIntervals++;
                tasksDone++;
            }
            for (int count : remainingTasks) {
                if (count > 0) maxHeap.offer(count);
            }
            if (!maxHeap.isEmpty())
                totalIntervals += (n + 1 - tasksDone);
        }
        return totalIntervals;
    }
}