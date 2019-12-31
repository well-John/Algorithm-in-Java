package leetcode.S040;

import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            List<Integer> list = new ArrayList<>(pre);
            if (!isHave(list)) {
                res.add(list);
            }
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i + 1, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public boolean isHave(List<Integer> list) {
        for (List<Integer> t : res) {
            if (t.size() == list.size()) {
                int size = t.size();
                while (size > 0 && t.get(size - 1).equals(list.get(size - 1))) {
                    size--;
                }
                if (size == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        Solution solution = new Solution();
        List<List<Integer>> combinationSum = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum);
    }


}
