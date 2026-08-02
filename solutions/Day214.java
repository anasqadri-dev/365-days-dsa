class Day214 {
    class MatrixCell {
        int value;
        int row;
        int column;
        MatrixCell(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length;
        PriorityQueue<MatrixCell> minHeap = new PriorityQueue<>((firstCell, secondCell) -> firstCell.value - secondCell.value);
        for (int row = 0; row < size; row++)
            minHeap.offer(new MatrixCell(matrix[row][0], row, 0));
        for (int count = 1; count < k; count++) {
            MatrixCell currentCell = minHeap.poll();
            if (currentCell.column + 1 < size)
                minHeap.offer(new MatrixCell(matrix[currentCell.row][currentCell.column + 1], currentCell.row, currentCell.column + 1));
        }
        return minHeap.peek().value;
    }
}