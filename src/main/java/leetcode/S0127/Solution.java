package leetcode.S0127;

import java.util.*;


/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!isCanTransfer(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }

            }


        }
        return 0;
    }

    public boolean isCanTransfer(String origin, String dest) {
        if (origin.length() != dest.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) != dest.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog"));

        int ladderLength = solution.ladderLength("hot", "dog", wordList);
        System.out.println(ladderLength);

    }
}
