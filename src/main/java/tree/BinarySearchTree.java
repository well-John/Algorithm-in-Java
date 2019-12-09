package tree;

public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node node = tree;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            return;
        }

        //要删除的节点还有两个子节点


        //要删除的节点时叶子节点或者只有一个节点

        //要删除的节点为根节点
    }


    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node tmp = tree;

        while (tmp != null) {
            if (data > tmp.data) {
                if (tmp.right == null) {
                    tmp.right = new Node(data);
                    return;
                }
                tmp = tmp.right;
            } else {
                if (tmp.left == null) {
                    tmp.left = new Node(data);
                    return;
                }
                tmp = tmp.left;
            }
        }
    }


    public static class Node {
        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
