package offer;

/**
 * 面试题20：表示数值的字符串
 * 测试平台：https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem20 {

    /**
     * 解题思路：用正则匹配的方法来进行判断
     *
     * []  ： 字符集合
     * ()  ： 分组
     * ?   ： 重复 0 ~ 1
     * +   ： 重复 1 ~ n
     * *   ： 重复 0 ~ n
     * .   ： 任意字符
     * \\. ： 转义后的 .
     * \\d ： 数字
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0){
            return false;
        }

        // 创建正则匹配规则
        //[+-]?：表示+/-要么可有可无
        //\\d*：表示有多个数字
        //(\\.\\d+)?：表示后面如果是包含小数部分的内容，那么就必须包含\\.\\d+，表示小数点后面必须包含一个整数
        //([eE][+-]?\\d+)?：表示如果是指数，那么必须包含([eE][+-]?\\d+)部分。
        String regex = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        return new String(str).matches(regex);
    }


    public static void main(String[] args){
        Problem20 p = new Problem20();
        System.out.println(p.isNumeric("+100".toCharArray()));
        System.out.println(p.isNumeric("5e2".toCharArray()));
        System.out.println(p.isNumeric("-123".toCharArray()));
        System.out.println(p.isNumeric("3.1415".toCharArray()));
        System.out.println(p.isNumeric("-1E-16".toCharArray()));

    }
}
