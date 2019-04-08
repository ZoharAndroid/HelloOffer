package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50_1：第一次只出现一次的字符
 *
 */
public class Problem50_1 {

    /**
     * 用数组来解决
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        // 记录字符出现的次数
        char[] counts = new char[256];
        // 添加出现的次数
        for (int i = 0; i < str.length(); i++){
            counts[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++){
            if (counts[str.charAt(i)] == 1){
                return i;// 返回出现的位置
            }
        }

        return -1;
    }


    /**
     * 用hash方法来决绝
     *
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
