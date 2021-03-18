package leetcode.S049;

import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (int i =0;i<strs.length;i++){
            char[] charArray =  strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            List<String> list= map.getOrDefault(key,new ArrayList<>());
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
