package queue;

/**
 * 用数组实现一个队列
 */
public class ArrayQueue {
    private int size;

    private int[] data;

    private int front;

    private int rear;

    public ArrayQueue(int size) {
        this.size = size;
        data = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public boolean push(Integer value) {
        if (this.rear >= this.size) {
            return false;
        }
        data[rear] = value;
        rear++;
        return true;
    }

    public Integer pop() {
        if (front == rear) {
            return null;
        }
        int result = data[front];
        front++;
        return result;
    }

    public void display() {
        if (front == rear) {
            System.out.println("当前队列为空");
        }
        for (int i = front; i < rear; i++) {
            System.out.println(data[i]);
        }

    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(8);

        for (int i = 1; i <= 8; i++) {
            arrayQueue.push(i);
        }
        arrayQueue.display();

        int pop = arrayQueue.pop();
        System.out.println("pop = " + pop);

        arrayQueue.display();

        arrayQueue.push(1);
        System.out.println("============");
        arrayQueue.display();
    }
}
