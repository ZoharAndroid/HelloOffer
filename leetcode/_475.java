package leetcode;

public class _475 {

    /**
     * 475. 供暖器
     * <p>
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     * <p>
     * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
     * <p>
     * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
     * <p>
     * 说明:
     * <p>
     * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
     * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
     * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
     * 所有供暖器都遵循你的半径标准，加热的半径也一样。
     * 示例 1:
     * <p>
     * 输入: [1,2,3],[2]
     * 输出: 1
     * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4],[1,4]
     * 输出: 1
     * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/heaters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findRadius(new int[]{1,2,3}, new int[]{2})); // 1
        System.out.println(s.findRadius(new int[]{1,2,3, 4}, new int[]{1,4})); // 1

    }

    static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            /**
             * 对于每一个房屋而言，不是前面有暖气就是后面有暖气，判断距离前后取暖距离较小的；
             * 对于整个房屋而言，取每个房屋距离暖气最大的值即可。
             */
            int max = 0;
            for (int house : houses) {
                // 对于每个房屋而言，判断前后的距离，取最小值
                int min = Math.abs(house - heaters[0]);
                for (int heater : heaters) {
                    min = Math.min(Math.abs(house - heater), min);
                }
                //将最大值重新设置
                if (max < min) {
                    max = min;
                }
            }

            return max;
        }
    }
}
