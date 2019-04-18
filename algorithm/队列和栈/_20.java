package algorithm.队列和栈;

import java.util.Stack;


/**
 * 20. 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20 {

    private boolean isValid(String s) {

        // 解题思路：其实这个问起就是栈的一个应用，当遍历字符串，每次进入一个括号，判断是否栈中最上面的是否是匹配的括号，
        // 如果是匹配的括号就出栈，
        // 如果不是匹配的，就进栈

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            // 遍历每个字符，判断栈中的顶部字符是否为匹配的括号
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{'){
                stack.push(temp);
            }else if (temp == ')' ){
                if (!stack.isEmpty() && stack.peek() == '(' ){
                    stack.pop();
                }else{
                    return false;
                }
            }else if (temp == ']'){
                if (!stack.isEmpty() && stack.peek() == '[' ){
                    stack.pop();
                }else{
                    return false;
                }
            }else if (temp == '}'){
                if (!stack.isEmpty() && stack.peek() == '{' ){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        // 最后操作完毕，判断栈中是否元素，如果还有元素，表示不匹配，如果没有元素了，那么就匹配完成了
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        _20 p = new _20();
        System.out.println(p.isValid(""));
    }
}
