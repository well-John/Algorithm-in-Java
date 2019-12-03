package queue;

import linklist.SingleLinkList;

/**
 * 链表队列
 */
public class LinkListQueue {

    private SingleLinkList<Integer> data;

    private int size;

    private int front;

    private int rear;

    public LinkListQueue(int size) {
        this.size = size;
        data = new SingleLinkList<>();
        this.front = 0;
        this.rear = 0;
    }


    public boolean push(Integer val) {
        if (this.rear >= this.size) {
            return false;
        }
        data.addLast(val);
        rear++;
        return true;
    }

    public Integer pop() {
        if (front == rear) {
            return null;
        }
        int result = data.get(front + 1);
        front++;
        return result;
    }

    public void display() {
        for (int i = front; i < rear; i++) {
            System.out.println(data.get(i + 1));
        }

    }

    public static void main(String[] args) {
        LinkListQueue linkListQueue = new LinkListQueue(10);

        for (int i = 1; i <= 10; i++) {
            linkListQueue.push(i);
        }
        linkListQueue.display();

        Integer pop = linkListQueue.pop();
        System.out.println("pop = " + pop);
        linkListQueue.display();

        linkListQueue.push(1);
        System.out.println("============");
        linkListQueue.display();
    }
}
