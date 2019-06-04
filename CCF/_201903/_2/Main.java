package CCF._201903._2;

import java.util.Scanner;
import java.util.Stack;

/**
 * 201903-2
 *
 * 二十四点
 *
 * http://118.190.20.162/view.page?gpid=T88
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：用两个栈来进行处理，遇到数字则直接压入栈
        // 遇到 + -号，则压入符号栈，遇到 x /号，则直接计算，然后
        // 把计算的结果压入到数据栈中
        // 最后计算最后一个数是否是24，如果是24则输出Yes，否则，输出No
        // 这里平台上所给的测试用例都是正确的，但是只有30分，
        // 不知道哪个地方有问题，后面再处理。

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] strs = new String[len];
        for (int i = 0; i < len; i++){
            strs[i] = sc.next();
        }

        for (int i = 0; i < len; i++){
            System.out.println(is24Number(strs[i]));
        }
    }

    private static String is24Number(String str){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; ){
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9'){
                numStack.push(temp - '0');
            }else if (temp == '+' || temp == '-'){
                operStack.push(temp);
            }else if (temp == 'x' || temp == '/'){
                int a = numStack.pop();
                int b = str.charAt(++i) - '0';
                int sum;
                if (temp == 'x') {
                    sum =  a * b;
                } else {
                    sum = a/b;
                }
                numStack.push(sum);

            }
            i++;
        }

        // 操作两个栈
        while (!operStack.isEmpty()){
            char operator = operStack.pop();
            int b = numStack.pop();
            int a = numStack.pop();

            if (operator == '+'){
                numStack.push(a + b);
            }else{
                numStack.push(a-b);
            }
        }

        if (numStack.pop() == 24){
            return "Yes";
        }else{
            return "No";
        }
    }
}
