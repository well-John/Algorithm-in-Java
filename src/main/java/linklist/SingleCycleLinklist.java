package linklist;

/**
 *
 */
public class SingleCycleLinklist<T> {

    class Node {
        private T val;
        private Node next;

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //头指针
    private Node head;
    //链表长度
    private int size = 0;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SingleCycleLinklist() {
        this.head = new Node(null, null);
        head.next = head;
        this.size = 0;
    }

    public void addFirst(T t) {
        Node node = new Node(t);
        Node target = head;
        while (target.next != head) {
            target = target.next;
        }
        target.next = node;
        node.next = head;
        head = node;
        this.size++;
    }

    public void addLast(T t) {
        Node node = new Node(t);
        Node target = head;
        while (target.next != head) {
            target = target.next;
        }
        target.next = node;
        node.next = head;
        this.size++;
    }

    private void rangCheck(int index) {
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("index is error");
        }
    }

    public void add(T t, int index) {
        rangCheck(index);
        Node preHead = this.head;
        for (int i = 0; i < index - 1; i++) {
            preHead = preHead.next;
        }
        Node node = new Node(t);
        node.next = preHead.next;
        preHead.next = node;
        this.size++;
    }

    public void remove(int index) {
        rangCheck(index);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
    }

    public T get(int index) {
        rangCheck(index);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public Node getNode(int index) {
        rangCheck(index);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void display() {
        Node cur = head.next;
        while (cur != this.head) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SingleCycleLinklist<Integer> singleCycleLinklist = new SingleCycleLinklist<>();
        for (int i = 1; i < 10; i++) {
            singleCycleLinklist.addLast(i);
        }
        singleCycleLinklist.display();
        singleCycleLinklist.remove(2);
        singleCycleLinklist.display();
        System.out.println(singleCycleLinklist.getNode(8).next.equals(singleCycleLinklist.getHead()));

    }
}
