package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree {

    private Node root;

    public Node find(int data) {
        Node node = root;
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
        Node p = root;
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

        //要删除的节点还有两个子节点,处理完这步之后就会变成后面的情况
        //两个子节点-》删除叶子节点/删除只有一个子节点的节点
        if (p.left != null && p.right != null) {
            Node tmp = p.right;
            Node tmpP = p;
            while (tmp.left != null) {
                tmpP = tmp;
                tmp = tmp.left;
            }
            p.data = tmp.data;
            pp = tmpP;
            p = tmp;
        }


        //要删除的节点为叶子节点或者只有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }


        //删除的为根节点
        if (pp == null) {
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }


    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node tmp = root;

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

    //前序遍历(递归)
    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    //前序遍历(非递归)
    public void preOrderNoRecursion(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node t1 = stack.pop();
            if (t1.right != null) {
                stack.push(t1.right);
            }

            if (t1.left != null) {
                stack.push(t1.left);
            }
            System.out.print(t1.data + " ");
        }
    }


    //前序遍历(非递归v2)
    public void preOrderNoRecursion_v2(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }

                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                node = stack.pop();
                System.out.print(node.data + " ");
            }
        }
    }


    //中序遍历(递归)
    public void middleOrder(Node root) {
        if (root == null) {
            return;
        }
        middleOrder(root.left);
        System.out.print(root.data + " ");
        middleOrder(root.right);
    }

    //中序遍历(非递归)
    public void middleOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    //中序遍历(非递归v2)
    public void middleOrderNoRecursion_v2(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }

                stack.push(node);
                stack.push(null);

                if (node.left != null) {
                    stack.push(node.left);
                }


            } else {
                stack.pop();
                node = stack.pop();
                System.out.print(node.data + " ");
            }
        }
    }


    //后序遍历(递归)
    public void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //后序遍历(非递归)
    public void postOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                map.put(root.data, 1);
                root = root.left;
            } else {
                root = stack.peek();
                if (map.get(root.data) == 2) {
                    stack.pop();
                    System.out.print(root.data + " ");
                    root = null;
                } else {
                    map.put(root.data, 2);
                    root = root.right;
                }
            }
        }
    }

    //后序遍历(非递归v2)
    public void postOrderNoRecursion_v2(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }


            } else {
                stack.pop();
                node = stack.pop();
                System.out.print(node.data + " ");
            }
        }
    }




    //层级遍历
    public void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node.data + " ");
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


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[]{8, 6, 10, 5, 7, 9, 12, 2, 4};
        //int[] arr = new int[]{5,4,6,1,2};

        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        System.out.println("前序遍历(递归)：");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("中序遍历(递归)：");
        tree.middleOrder(tree.root);
        System.out.println();
        System.out.println("后序遍历(递归)：");
        tree.postOrder(tree.root);
        System.out.println();


        System.out.println("前序遍历(非递归)：");
        tree.preOrderNoRecursion(tree.root);
        System.out.println();

        System.out.println("前序遍历(非递归V2)：");
        tree.preOrderNoRecursion_v2(tree.root);
        System.out.println();

        System.out.println("中序遍历(非递归)：");
        tree.middleOrderNoRecursion(tree.root);
        System.out.println();

        System.out.println("中序遍历(非递归V2)：");
        tree.middleOrderNoRecursion_v2(tree.root);
        System.out.println();


        System.out.println("后序遍历(非递归)：");
        tree.postOrderNoRecursion(tree.root);
        System.out.println();

        System.out.println("后序遍历(非递归V2)：");
        tree.postOrderNoRecursion_v2(tree.root);
        System.out.println();


        System.out.println("层次遍历：");
        tree.levelOrder(tree.root);
        System.out.println();

    }
}
