package algorithm.数组和字符串;

/**
 *
 * 14 最长公共前缀
 */
public class _14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        // 这里主要解题思想就是：
        // 以一个字符串为标准（最短长度），每次递增1个字符，如果没有该字符，说明没有公共字符了，也就可以直接反返回了，
        // 如果有公共字符，然后增加1个字符，继续判断其他字符是否是有相同的字符。
        String str = strs[0]; // 找出最小字符串
        int index = 0; // 最小字符串索引
        for (int i = 1; i < strs.length; i++){
            if (str.length() > strs[i].length()){
                str = strs[i];
                index = i;
            }
        }

        // 然后依次递增1个字符，判断其他的每个字符是否包含有相同的子字符串
        //StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));// 添加子字符
            for (int j = 0; j < strs.length; j++){
                // 判断其他的字符串中是否包含了子字符
                if (j != index){
                    // 排除自己本身
                    if (!strs[j].substring(0,i+1).equals(sb.toString())){
                        // 判断是否包含
                        // 如果不包含当前子字符串
                        // 如果当前字符不满足要求，那么就删除该字符
                        return sb.deleteCharAt(sb.length() - 1).toString();
                    }
                }
            }

        }

        return sb.toString();

    }

    public static void main(String[] args){
        _14 p = new _14();
        System.out.println(p.longestCommonPrefix(new String[]{"ca","a"}));
    }
}
