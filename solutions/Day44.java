import java.util.ArrayList;
import java.util.List;

public class Day44 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int layer = 0;
        while (layer * 2 < m && layer * 2 < n) {
            for (int i = layer; i < n - layer; i++) {
                result.add(matrix[layer][i]);
            }
            for (int i = layer + 1; i < m - layer; i++) {
                result.add(matrix[i][n - layer - 1]);
            }
            if (m - layer - 1 != layer) {
                for (int i = n - layer - 2; i >= layer; i--) {
                    result.add(matrix[m - layer - 1][i]);
                }
            }
            if (n - layer - 1 != layer) {
                for (int i = m - layer - 2; i > layer; i--) {
                    result.add(matrix[i][layer]);
                }
            }
            layer++;
        }
        return result;
    }
}