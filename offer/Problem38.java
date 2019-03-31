package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 面试题39：字符串的排列
 *
 */
public class Problem38 {

    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        if (str == null|| str.length() == 0) {
            return result;
        }

        // 转化成字符数组
        char[] chars = str.toCharArray();
        // 进行排序
        Arrays.sort(chars);
        // 调用函数
        permutation(chars, new boolean[chars.length], new StringBuilder());

        return result;
    }

    private void permutation(char[] chars, boolean[] flags, StringBuilder s){
        // 递归出口
        if (chars.length == s.length()){
            result.add(s.toString());
            return;
        }

        // 循环每个字符
        for (int i = 0; i < chars.length; i++){

            if (flags[i]){
                // 如果当前的标志位为true，说明已经使用过了，就不继续参与排列了
                continue;
            }

            if (i != 0 && chars[i] == chars[i - 1] && !flags[i - 1]){
                // 当前的字符与前面的字符相同，并且前面的字符标志位false，说明这两个字符排序是相同的，就不在进行排列了
                continue;
            }

            // 排除以上两种情况
            flags[i] = true; // 标志说明已经使用过这个字符
            s.append(chars[i]); // 添加这个字符
            // 递归调用
            permutation(chars, flags, s);
            // 递归返回的时候还原
            s.deleteCharAt(s.length() -  1);
            flags[i] = false;
        }
    }
}
