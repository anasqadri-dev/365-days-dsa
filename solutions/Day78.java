import java.util.ArrayList;
import java.util.List;

public class Day78 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (endIndex - startIndex + 1 > k) {
            int distanceFromStart = Math.abs(arr[startIndex] - x);
            int distanceFromEnd = Math.abs(arr[endIndex] - x);
            if (distanceFromStart > distanceFromEnd)
                startIndex++;
            else
                endIndex--;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++)
            answer.add(arr[i]);
        return answer;
    }
}