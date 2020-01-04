package leetcode;

public class _461 {

    /**
     *
     * 461. 汉明距离
     *
     * https://leetcode-cn.com/problems/hamming-distance/
     *
     *  两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hamming-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1,4));
    }

    static class Solution {

        public int hammingDistance(int x, int y) {
            /**
             * 直接异或异或，然后读取1的个数
             */
            int temp = x ^ y;

            String s = Integer.toBinaryString(temp);

            int count = 0;
            for (Character ch : s.toCharArray()){
                if (ch == '1'){
                    count++;
                }
            }

            return count;

        }
    }
}
