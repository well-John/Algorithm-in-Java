package linklist;

public class DoubleLinkList<T> {

    class Node {
        private T val;
        private Node next;
        private Node prev;

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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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

    private Node head;

    private Node last;

    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleLinkList() {
        Node node = new Node();
        head = node;
        last = node;
        this.size = 0;
    }

    public void addFirst(T t) {
        Node node = new Node(t);
        node.next = head;
        head.prev = node;
        head = node;
        this.size++;
    }

    public void addLast(T t) {
        Node node = new Node(t);
        last.next = node;
        node.prev = last;
        last = node;
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
        preHead.next.prev = node;
        preHead.next = node;
        node.prev = preHead;
        this.size++;
    }

    public void remove(int index) {
        rangCheck(index);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = prev.next.next;
        prev.next.prev = prev;
        cur.next = null;
        cur.prev = null;
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

    public void displayLeft() {
        Node cur = this.head;
        while (cur != null) {
            if (cur.val != null) {
                System.out.print(cur.val + "->");
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public void displayRight() {
        Node cur = this.last;
        while (cur != null) {
            if (cur.val != null) {
                System.out.print( cur.val+"->");
            }
            cur = cur.prev;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList<Integer>();
        for (int i = 1; i <= 10; i++) {
            doubleLinkList.addFirst(i);
        }
        doubleLinkList.displayLeft();
        doubleLinkList.displayRight();
        doubleLinkList.remove(5);
        System.out.println(" ==================== ");
        doubleLinkList.displayLeft();
        doubleLinkList.displayRight();
        doubleLinkList.add(12,5);
        System.out.println(" ==================== ");
        doubleLinkList.displayLeft();
        doubleLinkList.displayRight();
        System.out.println(" ==================== ");
        System.out.println(doubleLinkList.get(5));
    }

}
