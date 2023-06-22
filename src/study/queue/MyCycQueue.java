package study.queue;

public class MyCycQueue {
    private final int size = 4;
    private final int[] arr = new int[size + 1];
    private int front = 0;
    private int rear = 0;

    public MyCycQueue() {
    }

    public static void main(String[] args) {
        MyCycQueue q = new MyCycQueue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println("q.deQueue() = " + q.deQueue());
        q.enQueue(5);
    }

    public void enQueue(int x) {
        // 다음에 데이터가 들어가는 곳: (rear + 1) % (size + 1)
        // 다음에 데이터가 나올 곳과 일치 할 경우 Full
        if ((rear + 1) % (size + 1) == front) {
            throw new RuntimeException("queue is full");
        }
        rear = (rear + 1) % (size + 1);
        System.out.println("rear = " + rear);
        arr[rear] = x;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }

        front = (front + 1) % (size + 1);
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
