package stack;

/**
 * 用数组实现一个栈
 */
public class ArrayStack {

    private String[] data;

    private int count;

    private int size = 0;

    public ArrayStack(int n) {
        this.data = new String[n];
        this.size = n;
        this.count = 0;
    }

    public boolean push(String value) {
        if (this.count == this.size) {
            return false;
        }
        data[count] = value;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String tmp = data[count-1];
        count--;
        return tmp;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(String.valueOf(i));
        }
        arrayStack.display();
        System.out.println("============================");
        arrayStack.pop();
        arrayStack.display();
    }

}
