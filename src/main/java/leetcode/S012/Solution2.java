package leetcode.S012;

/**
 * 使用贪心算法
 */
public class Solution2 {

    public String intToRoman(int num) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String roman = new Solution2().intToRoman(4);
        System.out.println(roman);

    }
}
