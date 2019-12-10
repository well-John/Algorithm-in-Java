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
        if (p.left != null && p.right != null) {
            Node tmp = p.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            p.data = tmp.data;
            p = tmp;
        }


        //要删除的节点为叶子节点
        if (p.left == null && p.right == null) {
            if (pp.left == p) {
                pp.left = null;
            } else {
                pp.right = null;
            }
        }


        //要删除的节点只有一个子 节点(左节点/右节点)
        if ((p.left == null && p.right != null) || (p.left != null && p.right == null)) {
            Node child;
            if (p.left != null) {
                child = p.left;
            } else {
                child = p.right;
            }
            if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }
        }


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
