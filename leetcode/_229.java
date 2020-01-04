package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _229 {


    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println(s.getHint("1807", "7810"));
        System.out.println(s.getHint("1123", "0111"));
    }

    static class Solution {
        public String getHint(String secret, String guess) {
            /**
             * 先用hash表来判别有几个相对应的，这些对应的先不管位置，即判断的
             * 数字有几个是相同的，这里也就是母牛的个数了；
             * 然后依次比较每个位置是否的数字是否相同，如果相同
             * 那么就是公牛的数，相应的，母牛的数量就需要减去1一个了。
             */

            Map<Character, Integer> map = new HashMap<>();
            for (Character temp : secret.toCharArray()){
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            // 从map中判断
            int countB = 0, countA= 0;
            for (Character temp : guess.toCharArray()){
                if (map.getOrDefault(temp, 0) != 0){
                    // 比较之后需要重新处理需要减去1
                    map.put(temp, map.get(temp) - 1);
                    countB++; // 母牛数+1
                }
            }

            // 依次比较两个字符串的每一位是否相同
            char[] chars = secret.toCharArray();
            for (int i =0; i < chars.length; i++){
                if (chars[i] == guess.charAt(i)){
                    countA++;
                }
            }

            countB = countB - countA;

            return countA+"A"+countB+"B";
        }
    }
}
