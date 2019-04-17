package algorithm.数组和字符串;

/**
 * 151. 翻转字符串里的单词
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class _151 {

    private String reverseWords(String s) {

        // 解题思路：首先可以用trim方法去除收尾的空格，方便后面的操作。
        // 从后面往前面遍历，直到遇到空格，形成一个单词后，然后再反转一下，添加一个空格后，在添加到到新建的字符串变量中，

        String str = s.trim();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean flag = false;
        for (int i = str.length() - 1; i >=0 ; i--){
            if (str.charAt(i) == ' ' ){
                if (i != 0 && str.charAt(i - 1) == ' '){
                    // 如果一个单词搞完了，后面还是空格，就需要继续处理了：也就是直接跳过
                    continue;
                }
                // 说明一个单词搞完了
                word.reverse();
                result.append(word + " ");
                word = new StringBuilder();
            }else{
                word.append(str.charAt(i));
                //  注意，这里需要做的是对首个单词的处理，因为一开始就把字符串收尾的空格去除掉了，那么第一个单词就没有判断的标志了
                // 所以这里需要单独对第一个单词进行处理
                if (i == 0 && str.charAt(i) != ' '){
                    word.reverse();
                    result.append(word);
                }
            }
        }


        return result.toString();
    }

    public static void main(String[] args){
        _151 p = new _151();
        System.out.println(p.reverseWords(" a good   example"));
    }
}
