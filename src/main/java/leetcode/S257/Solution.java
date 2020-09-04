package leetcode.S257;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//257. 二叉树的所有路径
public class Solution {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        constrtPath(root, "", result);

        return result;
    }

    private void constrtPath(TreeNode root, String path, List<String> result) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);

            if (root.left == null && root.right == null) {
                result.add(sb.toString());
            } else {
                sb.append("->");
                constrtPath(root.left, sb.toString(), result);
                constrtPath(root.right, sb.toString(), result);
            }
        }

    }

    public List<String> binaryTreePathsByBFS(TreeNode root) {

        List<String> paths = new ArrayList<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.offer(root);
            pathQueue.offer(Integer.toString(root.val));
        }

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
