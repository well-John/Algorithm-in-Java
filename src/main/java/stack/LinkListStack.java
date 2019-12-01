package stack;

import linklist.SingleLinkList;

public class LinkListStack {

    private SingleLinkList<String> data;

    private int size;

    public LinkListStack(int size) {
        data = new SingleLinkList<>();
        this.size = size;
    }

    public boolean push(String value) {
        if (this.size == data.getSize()) {
            return false;
        }
        data.addLast(value);
        return true;
    }

    public String pop() {
        if (data.getSize() == 0) {
            return null;
        }
        int size = data.getSize();
        String result = data.get(size);
        data.remove(size);
        return result;
    }

    public void display() {
        data.display();
    }

    public static void main(String[] args) {
        LinkListStack stack = new LinkListStack(10);

        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));
        }
        stack.display();

        String pop = stack.pop();
        System.out.println("pop = " + pop);

        stack.display();

    }
}
