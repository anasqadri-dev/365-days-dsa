class Day258 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;
            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return completedCourses == numCourses;
    }
}