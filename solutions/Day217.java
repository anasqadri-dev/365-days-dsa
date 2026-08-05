class Day217 {
    class Project {
        int capitalRequired;
        int profit;
        Project(int capitalRequired, int profit) {
            this.capitalRequired = capitalRequired;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int numberOfProjects = profits.length;
        Project[] projects = new Project[numberOfProjects];
        for (int i = 0; i < numberOfProjects; i++)
            projects[i] = new Project(capital[i], profits[i]);
        Arrays.sort(projects, (first, second) ->
                first.capitalRequired - second.capitalRequired);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (firstProfit, secondProfit) -> secondProfit - firstProfit );
        int currentProject = 0;
        for (int i = 0; i < k; i++) {
            while (currentProject < numberOfProjects && projects[currentProject].capitalRequired <= w) {
                maxHeap.offer(projects[currentProject].profit);
                currentProject++;
            }
            if (maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
}