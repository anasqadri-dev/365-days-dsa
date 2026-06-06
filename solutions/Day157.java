public class Day157 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int availableSlots = 1;
        for (int i = 0; i < nodes.length; i++) {
            availableSlots--;
            if (availableSlots < 0) return false;
            if (!nodes[i].equals("#"))
                availableSlots = availableSlots + 2;
        }
        return availableSlots == 0;
    }
}