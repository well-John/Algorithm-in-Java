package SegmentTree;

/**
 * 线段树 -- 一种求区间和 和 更新下标值 时间复杂度为log(n)的数据结构
 */
public class SegmentTree {

    /**
     * @param arr   原数组
     * @param tree  线段树数组，值存放的是某个区间的和
     * @param node  线段树节点下标，从0开始
     * @param start 原数组开始下标
     * @param end   原数组结束下标
     */
    public void buildTree(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            //将区间一分为二[start,mid],[mid+1,end]
            int mid = (start + end) / 2;
            //左孩子的下标
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            //递归求和
            buildTree(arr, tree, left_node, start, mid);
            buildTree(arr, tree, right_node, mid + 1, end);
            tree[node] = tree[left_node] + tree[right_node];
        }
    }

    /**
     * @param arr
     * @param tree
     * @param node
     * @param start
     * @param end
     * @param L     需要求和左区间值
     * @param R     需要求和右区间值
     * @return
     */
    public int sum_tree(int[] arr, int[] tree, int node, int start, int end, int L, int R) {
        //不在区间之中，直接返回
        if (start > R || end < L) {
            return 0;
        } else if (start >= L && end <= R) {
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            int left_sum = sum_tree(arr, tree, left_node, start, mid, L, R);
            int right_sum = sum_tree(arr, tree, right_node, mid + 1, end, L, R);
            return left_sum + right_sum;
        }
    }

    /**
     * 更新某个下标值
     *
     * @param arr
     * @param tree
     * @param node
     * @param start
     * @param end
     * @param index 原数组更新的下标
     * @param val   更新后的值
     */
    public void update_tree(int[] arr, int[] tree, int node, int start, int end, int index, int val) {
        int mid = (start + end) / 2;
        int left_node = 2 * node + 1;
        int right_node = 2 * node + 2;
        if (start == end) {
            tree[node] = val;
            arr[index] = val;
            return;
        }

        if (index >= start && index <= mid) {
            update_tree(arr, tree, left_node, start, mid, index, val);
        } else {
            update_tree(arr, tree, right_node, mid + 1, end, index, val);
        }
        tree[node] = tree[left_node] + tree[right_node];
    }

    public static void main(String[] args) {
        int[] arr = {0, -3, -3, 1, 1, 2};
        int[] tree = new int[4 * arr.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.MIN_VALUE;
        }

        SegmentTree segmentTree = new SegmentTree();
        segmentTree.buildTree(arr, tree, 0, 0, arr.length - 1);
        segmentTree.update_tree(arr, tree, 0, 0, arr.length - 1, 2, 6);
        int sum_tree = segmentTree.sum_tree(arr, tree, 0, 0, arr.length - 1, 2, 5);
        System.out.println(sum_tree);
    }
}
