package leetcode.S0103;

import define.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.add(root);
        boolean left = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(left){
                    tmp.add(node.getVal());
                }else {
                    tmp.add(0,node.getVal());
                }

                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
            }
            res.add(tmp);
            left = !left;
        }

        return res;
    }
}
