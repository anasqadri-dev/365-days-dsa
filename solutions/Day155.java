class Day155 {
    int arr[];
    int front=-1, rear=-1;
    int count = 0;
    public MyCircularQueue(int k) { arr = new int[k]; }
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()) front = 0;
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        count++;
        return true;
    }
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(count==1){
            front = -1;
            rear = -1;
        } else front = (front + 1) % arr.length;
        count--;
        return true;
    }
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }
    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == arr.length; }
}