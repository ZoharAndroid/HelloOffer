package offer;

import java.util.Arrays;

/**
 * 面试题48：最长不含重复字符的子字符串
 */
public class Problem48 {

    public int longestSubstringwithoutDuplication(String str){
        if(str == null){
            return 0;
        }

        int curLen = 0; // 当前长度
        int maxLen = 0; // 最长长度
        int[] postion = new int[26]; //存储每个字符上一次出现在字符中的位置索引
        Arrays.fill(postion, -1); // 将这个数组上的所有字符都填充-1，表示字符串还没出现过这个字符
        for (int i = 0; i < str.length(); i++){
            int preIndex = postion[str.charAt(i) - 'a']; // 读取该字符上一次出现在str中索引位置
            if (preIndex < 0 || i - preIndex > curLen){
               // 如果读取的该字符索引为负数，说明这个字符还没有出现过 或者，
                // 当前字符索引 减去 读取str中前面已经出现过该字符的索引位置 的距离已经大于了当前的长度，说明，重复的字符已经不在子字符串中了
                ++curLen;
            }else{
                // 如果有重复了,重新设置最大值
                maxLen = Math.max(curLen, maxLen);
                // 重新设置一下当前的长度
                curLen = i - preIndex;
            }

            // postion相应数组中设置一下该字符在str中的位置
            postion[str.charAt(i) - 'a'] = i;
        }

        maxLen = Math.max(curLen, maxLen);

        return maxLen;
    }

    public static void main(String[] args){
        Problem48 p = new Problem48();
        System.out.println(p.longestSubstringwithoutDuplication("arabcacfr"));
    }
}
