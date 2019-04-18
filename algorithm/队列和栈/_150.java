package algorithm.队列和栈;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150 {

    // 解题思路：通过栈来解决这个问题，首先当遇到的是数字的时候，就直接压入栈，当遇到是操作符的时候，从栈中取两个数进行操作，这里需要注意的是
    // 这两个数的位置(通过例子也可以看出)，然后把操作后的结果压入栈
    // 给定的形参是字符串数组，所以别忘记如果是数字字符的话需要转换成数字

    private int evalRPN(String[] tokens) {

        Stack<Integer>  stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++){
            String temp = tokens[i];
            if (!temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/")){
                // 如果是数字，直接压入栈
                stack.push(Integer.valueOf(temp));
            }else{
                // 如果是操作符
                int a = stack.pop();
                int b = stack.pop(); // 弹出两个数
                switch (temp){
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }
                stack.push(result);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args){
        _150 p = new _150();

        String[] tokens1 = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens2 = new String[]{"4", "13", "5", "/", "+"};
        String[] tokens3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(p.evalRPN(tokens3));
    }
}
