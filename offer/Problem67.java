package offer;


/**
 * // 面试题67：把字符串转换成整数
 * // 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * // 能使用atoi或者其他类似的库函数。
 */
public class Problem67 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0 ){
            return 0;
        }

        boolean isNegetive = false;
        int result = 0; // 输出的结果
        // 先直接判断正负号
        String newStr = str.trim(); // 去除前后空格
        isNegetive = newStr.charAt(0) == '-'; // 判断是否为负数
        for (int i = 0; i < newStr.length(); i++){
            if (i == 0 && (newStr.charAt(i) == '+' || newStr.charAt(i) == '-')){
               // 判断首位是否是符号位
                continue; // 如果是符号位直接跳过，前面已经处理了符号位
            }

            // 接下来判断是否是数字
            if (newStr.charAt(i) >= '0' && newStr.charAt(i) <= '9'){
                result = result * 10 + newStr.charAt(i)-'0';
            }else{
                return 0; // 如果不是数字那么就直接输出0 了
            }

        }

        return isNegetive ? -result : result;
    }


    public static void main(String[] args){
        Problem67 p = new Problem67();
        System.out.println(p.StrToInt("+2147483647")); // 2147483647
        System.out.println(p.StrToInt("1a33")); // 0
        System.out.println(p.StrToInt("")); // 0
        System.out.println(p.StrToInt("-123")); // -123
        System.out.println(p.StrToInt("-")); // 0
    }
}
