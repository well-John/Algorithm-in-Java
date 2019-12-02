package queue;

import static utils.CommonUtils.backward;

/**
 * 用数组实现一个队列
 */
public class ArrayQueue {
    private int size;

    private int[] data;

    private int end;

    public ArrayQueue(int size) {
        this.size = size;
        data = new int[size];
        this.end = 0;
    }

    public boolean push(Integer value) {
        if (this.end == this.size) {
            return false;
        }
        data[end] = value;
        end++;
        return true;
    }

    public Integer pop() {
        if(end == 0){
            return null;
        }
        int result = data[0];
        backward(data, 0, end - 1, 0);
        end--;
        return result;
    }

    public void display() {
        if (end == 0) {
            System.out.println("当前队列为空");
        }
        for (int i = 0; i < end; i++) {
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

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);

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
