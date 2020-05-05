package offer;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question45 {

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int tmp : nums) {
            list.add(String.valueOf(tmp));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : list) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Question45 question45 = new Question45();
        String s = question45.minNumber(nums);
        System.out.println(s);

    }

}
