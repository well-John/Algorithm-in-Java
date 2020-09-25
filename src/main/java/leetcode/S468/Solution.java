package leetcode.S468;

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
