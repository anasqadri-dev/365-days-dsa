class Day146 {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            int currentAsteroid = asteroids[i];
            boolean currentDestroyed = false;
            while (top != -1 && stack[top] > 0 && currentAsteroid < 0) {
                if (stack[top] < -currentAsteroid) {
                    top--;
                }
                else if (stack[top] == -currentAsteroid) {
                    top--;
                    currentDestroyed = true;
                    break;
                }
                else {
                    currentDestroyed = true;
                    break;
                }
            }
            if (currentDestroyed == false) {
                top++;
                stack[top] = currentAsteroid;
            }
        }
        int[] answer = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            answer[i] = stack[i];
        }
        return answer;
    }
}