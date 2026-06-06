class Day156 {
    int arr[];
    int front, rear;
    int count;
    public MyCircularDeque(int k) {
        arr = new int[k];
        front = rear = -1;
        count = 0;
    }
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()) front = rear = 0;
        else front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        count++;
        return true;

    }
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(isEmpty()) front=0;
        rear = (rear+1)%arr.length;
        arr[rear] = value;
        count++;
        return true;
    }
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(count==1) front = rear = -1;
        else front = (front+1) % arr.length;
        count--;
        return true;
    }
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(count==1) front = rear = -1;
        else rear = (rear - 1 + arr.length) % arr.length;
        count--;
        return true;
    }
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }
    public boolean isEmpty() { return count==0; }
    public boolean isFull() { return count==arr.length; }
}