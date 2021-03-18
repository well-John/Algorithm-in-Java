package leetcode.S017;

import java.util.*;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() ==0 ){
            return res;
        }

        Map<Character,String> phoneMap = new HashMap();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");

        backTracking(digits,0,phoneMap,new StringBuilder(),res);
        return res;
    }

    public void backTracking(String digits,int start,Map<Character,String> phoneMap,StringBuilder sb,List<String> res){
        if(start == digits.length()){
            res.add(sb.toString());
            return;
        }

        String s = phoneMap.get(digits.charAt(start));
        int length = s.length();
        for (int i=0;i<length;i++){
            sb.append(s.charAt(i));
            backTracking(digits,start+1,phoneMap,sb,res);
            sb.deleteCharAt(start);
        }

    }

    public static void main(String[] args) {

        List<String> strings = new Solution().letterCombinations("23");
        System.out.println(Arrays.toString(strings.toArray()));
    }

}
