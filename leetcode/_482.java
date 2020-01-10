package leetcode;

public class _482 {
    /**
     * 482. 密钥格式化
     * <p>
     * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     * <p>
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     * <p>
     * 示例 1：
     * <p>
     * 输入：S = "5F3Z-2e-9-w", K = 4
     * <p>
     * 输出："5F3Z-2E9W"
     * <p>
     * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     *      注意，两个额外的破折号需要删掉。
     * 示例 2：
     * <p>
     * 输入：S = "2-5g-3-J", K = 2
     * <p>
     * 输出："2-5G-3J"
     * <p>
     * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     *  
     * <p>
     * 提示:
     * <p>
     * S 的长度不超过 12,000，K 为正整数
     * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
     * S 非空
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/license-key-formatting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.licenseKeyFormatting("5F3Z-2e-9-w", 4));//5F3Z-2E9W
        System.out.println(s.licenseKeyFormatting("2-5g-3-J",2)); // 2-5G-3J
        System.out.println(s.licenseKeyFormatting("2-4A0r7-4k",4));// 24A0-R74K
    }

    static class Solution {
        public String licenseKeyFormatting(String S, int K) {
            /**
             * 注意看题目：第一字符可以是任意的，其余字符要确保是K个字符。
             */
            String[] s = S.split("-");
            StringBuilder sb = new StringBuilder();

            int count = 0;
            for (int i = s.length-1; i >= 0; i--) {
                for (int j = s[i].length()-1; j >=0 ; j--) {
                    if (count == K) {
                        count = 0;
                        sb.append("-");
                    }
                    sb.append(s[i].charAt(j));
                    count++;
                }
            }
            return sb.reverse().toString().toUpperCase();
        }
    }
}
