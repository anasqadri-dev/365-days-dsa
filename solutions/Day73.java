public class Day73 {
    public int[][] kClosest(int[][] points, int k) {
        int totalPoints = points.length;
        for (int i = 0; i < totalPoints - 1; i++) {
            for (int j = 0; j < totalPoints - i - 1; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int x2 = points[j + 1][0];
                int y2 = points[j + 1][1];
                int distance1 = x1 * x1 + y1 * y1;
                int distance2 = x2 * x2 + y2 * y2;
                if (distance1 > distance2) {
                    int tempX = points[j][0];
                    int tempY = points[j][1];
                    points[j][0] = points[j + 1][0];
                    points[j][1] = points[j + 1][1];
                    points[j + 1][0] = tempX;
                    points[j + 1][1] = tempY;
                }
            }
        }
        int[][] closestPoints = new int[k][2];
        for (int i = 0; i < k; i++)
            closestPoints[i] = points[i];
        return closestPoints;
    }
}
