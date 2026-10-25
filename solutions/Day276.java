public class Day276 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i])
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
        }
        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) return -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        queue.add(source);
        visitedStops.add(source);
        int buses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                for (int bus : stopToBuses.get(stop)) {
                    if (!visitedBuses.add(bus)) continue;
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        if (visitedStops.add(nextStop)) queue.add(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}