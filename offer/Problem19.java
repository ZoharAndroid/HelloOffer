package offer;

public class Problem19 {

    /**
     * 方法1
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null){
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
        if (str.length == strIndex && pattern.length == patternIndex){
            // 如果字符串和匹配模式都在最后了，表示检查完毕
            return true;
        }

        if (strIndex < str.length && pattern.length <= patternIndex){
            // 字符串还没有检查完毕，但是匹配模式检查完毕了，表示匹配失败
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            // 如果当前的字符的后一位字符为*
            if (strIndex >= str.length){
                //字符串完毕，但是匹配某事可以没有完毕，还可以继续检查1次
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }else {
                if (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' ) {
                    // 如果当前的字符相等，或者 当前字符匹配为。
                    // 移动到下一个字符进行匹配
                    return matchCore(str, strIndex + 1, pattern, patternIndex + 2)//有且只匹配1个字符
                            || matchCore(str, strIndex, pattern, patternIndex + 2) // 没有匹配的字符，那么pattern就向后移动2个字符位
                            || matchCore(str, strIndex + 1, pattern, patternIndex);// 有多个字符可以进行匹配
                } else {
                    // 如果当前字符不相等，那么模式匹配字符就向后移动两位
                    return matchCore(str, strIndex, pattern, patternIndex + 2);
                }
            }
        }

        if (strIndex >= str.length){
            return false;
        }else{
            if ( pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' ){
                //如果当前字符后一位不是*
                // 那么模式匹配和字符都想后面移动1位
               return  matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
        }


        return false;

    }

    /**
     * 方法2
     * @param str
     * @param pattern
     * @return
     */
    public boolean match2(char[] str, char[] pattern) {
        int strLen =  str.length;
        int patternLen = pattern.length;

        boolean[][] dp = new boolean[strLen + 1][patternLen + 1];

        dp[0][0] = true;
        for (int i = 1; i <= patternLen; i++){
            if (pattern[i - 1] == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= strLen; i++){
            for (int j = 1; j <= patternLen; j++){
                if (str[i -1] == pattern[j - 1] || pattern[j - 1] == '.'){
                    // 如果当前的字符相等 或者 匹配为 .
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (pattern[j - 1] == '*'){
                    // 如果前面的字符为*
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.'){
                        dp[i][j] |= dp[i][j-1];
                        dp[i][j] |= dp[i-1][j];
                        dp[i][j] |= dp[i][j - 2];
                    }else{
                        dp[i][j] |= dp[i][j - 2];
                    }
                }
            }
        }
        return dp[strLen][patternLen];
    }


    public static void main(String[] args){
        Problem19 p = new Problem19();
        System.out.println(p.match("aaa".toCharArray(),"a.a".toCharArray()));
        System.out.println(p.match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        System.out.println(p.match("aaa".toCharArray(),"aa.a".toCharArray()));
    }
}
