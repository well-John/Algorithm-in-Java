package leetcode.S0206;

public class Solution {

    static class Node {
        private int val;
        private Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
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

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse(Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void string(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(2);
        node1.next = node2;
        node2.next = node3;

        string(node1);
        Node reverse = reverse(node1);
        System.out.println("");
        string(reverse);


    }

}
