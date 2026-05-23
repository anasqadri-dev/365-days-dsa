public class Day143 {
    int[] requests;
    int front;
    int rear;

    public RecentCounter() {
        requests = new int[10000];
        front = 0;
        rear = 0;
    }

    public int ping(int t) {
        requests[rear] = t;
        rear++;
        while (requests[front] < t - 3000) {
            front++;
        }
        return rear - front;
    }
}