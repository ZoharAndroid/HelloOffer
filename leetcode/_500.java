package leetcode;


import java.util.ArrayList;
import java.util.List;

public class _500 {

    /**
     * 500. 键盘行
     * <p>
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
     * 示例：
     * <p>
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     *  
     * <p>
     * 注意：
     * <p>
     * 你可以重复使用键盘上同一字符。
     * 你可以假设输入的字符串将只包含字母。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/keyboard-row
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] result = s.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        String[] result1 = s.findWords(new String[]{"a", "b"});
        for (String str : result1) {
            System.out.print(str + " ");
        }
    }

    static class Solution {
        public String[] findWords(String[] words) {
            List<String> result = new ArrayList<String>();
            String[] strings = {
                    "qwertyuiop",
                    "asdfghjkl",
                    "zxcvbnm"
            };

            for (String word : words) {
                // 判断当前的单词是否满足
                if (deal(word.toLowerCase(), strings)) {
                    result.add(word);
                }
            }

            return result.toArray(new String[result.size()]);
        }

        public boolean deal(String word, String[] strings) {
            int line = 0;
            boolean result = true;
            // 判断当前word位于第几行
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].indexOf(word.charAt(0)) > -1) {
                    line = i;
                    break;
                }
            }

            // 判断后面的字符
            for (int i = 1; i < word.length(); i++) {
                if (strings[line].indexOf(word.charAt(i)) < 0) {
                    return false;
                }
                result = true;
            }
            return result;
        }
    }
}
