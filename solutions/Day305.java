public class Day305 {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private List<String> itinerary = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets)
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }
    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty())
            dfs(destinations.poll());
        itinerary.add(airport);
    }
}