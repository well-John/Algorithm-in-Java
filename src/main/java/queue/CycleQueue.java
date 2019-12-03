package queue;

/**
 *循环队列
 */
public class CycleQueue {

    private Integer[] data;

    private int size;

    private int front;

    private int rear;

    public CycleQueue(int size) {
        this.size = size;
        this.front = 0;
        this.rear = 0;
        data = new Integer[size];
    }

    public boolean push(int val) {
        if ((rear + 1) % size == front) {
            System.out.println("队列已满");
            return false;
        }
        data[rear] = val;
        rear = (rear+1)%size;
        return true;
    }

    public Integer pop() {
        if (rear == front) {
            System.out.println("队列已空");
            return null;
        }
        int result = data[front];
        front++;
        return result;
    }

    public void display() {
        int front = this.front;
        int rear = this.rear;
        while (front != rear) {
            System.out.println(data[front]);
            front = (front + 1) % size;
        }
    }

    public static void main(String[] args) {
        CycleQueue cycleQueue = new CycleQueue(8);

        for (int i =1;i<=8;i++){
            cycleQueue.push(i);
        }
        cycleQueue.display();

        int pop = cycleQueue.pop();
        System.out.println("pop = " + pop);
        cycleQueue.display();

        System.out.println("==========");

        cycleQueue.push(9);
        cycleQueue.display();
    }


}
