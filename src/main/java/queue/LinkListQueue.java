package queue;

import linklist.SingleLinkList;

/**
 * 链表队列
 */
public class LinkListQueue {

    private SingleLinkList<Integer> data;

    private int size;

    public LinkListQueue(int size) {
        this.size = size;
        data = new SingleLinkList<>();
    }

    public boolean push(Integer val) {
        if (data.getSize() == size) {
            return false;
        }
        data.addLast(val);
        return true;
    }

    public Integer pop() {
        Integer result = null;
        if (data.getSize() > 0) {
            result = data.get(1);
            data.remove(1);
        }
        return result;
    }

    public void display() {
        data.display();
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
