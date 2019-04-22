package algorithm.队列和栈;


import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/
 */
public class _394 {

    public String decodeString(String s) {

        // 解题思路：对一个字符串中的每个字符加入到栈中，遇到']'时，直到遇到'['该字符，然后再获取前面的数字字符，重复前面字符串
        // 组成新的字符串可以从新加入到栈中。其他的字符直接加入栈中。
        // 注意：这里有个小技巧就是，对于栈中的每个元素都是当做字符串来进行操作的，可以带来简便

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (cur == ']'){
                // 如果当前的字符是']'，那么就需要考虑出栈的情况了
                String string = "";
                while (!stack.peek().equals("[")){
                    string = stack.pop() + string;
                }
                stack.pop(); // 去除掉"["

                // 读取数字(注意在读取数字的时候，不一定只有1位数字
                String countStr = "";
                while (!stack.isEmpty() && stack.peek().charAt(0)>='0' && stack.peek().charAt(0) <= '9'){
                    countStr = stack.pop() + countStr;
                }
                int count = Integer.valueOf(countStr);

                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < count; j++){
                    temp.append(string);
                }
                stack.push(temp.toString());
            }else {
                // 其他情况则是直接push到堆栈中
                stack.push(cur+"");
            }

        }

        // 最高完毕的时候读取栈
        String str = "";
        while (!stack.isEmpty()){
            str = stack.pop() + str;
        }
        return str;
    }

    public static void main(String[] args){
        _394 p = new _394();
        System.out.println(p.decodeString("10[a]2[bc]"));
    }
}
