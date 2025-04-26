package Day2.QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }
        buffer[rear] = value;
        rear = (rear + 1) % capacity;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();

        buffer.insert(4);
        buffer.display();
    }
}
