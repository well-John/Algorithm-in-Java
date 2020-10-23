package leetcode.S1779;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<String> list;

    public String[] permutation(String S) {
        this.list = new ArrayList<>();
        char[] arr = S.toCharArray();
        // 需先排序
        Arrays.sort(arr);
        backTrack(new char[arr.length], new boolean[arr.length], arr, 0);
        String[] res = new String[list.size()];
        int i = 0;
        for (String x : list) {
            res[i++] = x;
        }
        return res;
    }

    // temp用于保存添加的字符，used用于标记各位置字符是否已被添加过，idx表示该次要在temp数组的对应索引位置添加字符
    public void backTrack(char[] temp, boolean[] used, char[] arr, int idx) {
        if (idx == arr.length) {
            list.add(new String(temp));
        } else {
            // lastUsed保存上一次在idx处添加的字符，' '表示idx为0时还没有字符被添加
            char lastUsed = ' ';
            for (int i = 0; i < arr.length; i++) {
                // 如果arr[i]未被使用过，且与上次使用的字符不一样，就进入添加操作，达到去重效果
                if (!used[i] && arr[i] != lastUsed) {
                    temp[idx] = arr[i];
                    used[i] = true;
                    backTrack(temp, used, arr, idx + 1);
                    lastUsed = arr[i];
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] permutation = solution.permutation("aaab");
        System.out.println(Arrays.toString(permutation));

    }
}
