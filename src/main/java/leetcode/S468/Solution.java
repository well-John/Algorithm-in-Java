package leetcode.S468;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为0 -255，用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址172.16.254.01 是不合法的。
 *
 * IPv6地址由 8 组 16 进制的数字来表示，每组表示16 比特。这些组数字通过 (":")分割。比如,2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。比如，2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如，02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public String validIPAddress(String ip) {

        if (ip.contains(".")) {
            int lastIndex = ip.lastIndexOf(".");
            if(lastIndex == ip.length()-1){
                return "Neither";
            }
            String[] ipv4 = ip.split("\\.");
            if (ipv4.length != 4) {
                return "Neither";
            }
            for (String s : ipv4) {
                if (s.length() <= 0 || s.length() > 3) {
                    return "Neither";
                }
                if (s.length() > 1 && s.charAt(0) == '0') {
                    return "Neither";
                }
                Integer value = null;
                try {
                    value = Integer.valueOf(s);
                } catch (Exception e) {
                }

                if (value == null || value < 0 || value > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (ip.contains(":")) {
            int lastIndex = ip.lastIndexOf(":");
            if(lastIndex == ip.length()-1){
                return "Neither";
            }
            String[] ipv6 = ip.split(":");
            if (ipv6.length != 8) {
                return "Neither";
            }

            for (String s : ipv6) {

                if (s.length() > 4 || s.length() <= 0) {
                    return "Neither";
                }

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    boolean isValid = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
                    if (!isValid) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";

        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String validIPAddress = solution.validIPAddress("1e1.4.5.6");
        System.out.println(validIPAddress);

    }

}
