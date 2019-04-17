package algorithm.数组和字符串;

/**
 * 557. 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class _557 {

    private String reverseWords(String s) {

        // 解题思路：题目已经说了，字符串不会有任何额外的空格，也就是告诉我们除了一般情况，其他的情况就不需要考虑了。
        // 对整个字符串进行空格切分，得到单词数组，然后对单词进行反转，接下来再进行拼接即可。

        if (s == " " || s.isEmpty() || s == null){
            return s;
        }

        String[] strs = s.split(" "); // 对单词进行切分
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++){
            // 对每个单词进行反转
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < strs[i].length(); j++){
                word.append(strs[i].charAt(j));
            }
            word.reverse();
            if (i != strs.length - 1){
                word.append(" ");
            }
            result.append(word);
        }

        return result.toString();
    }

    public static void main(String[] args){
        _557 p = new _557();
        System.out.println(p.reverseWords("Let's take LeetCode contest"));
    }

}
