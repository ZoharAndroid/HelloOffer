package leetcode;

public class _496 {
    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * <p>
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 示例 2:
     * <p>
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
     * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 注意:
     * <p>
     * nums1和nums2中所有元素是唯一的。
     * nums1和nums2 的数组大小都不超过1000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});  //-1 3 -1
        result = s.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});// 3 -1
         result = s.nextGreaterElement(new int[]{1,3,5,2,4},new int[]{6,5,4,3,2,1,7}); // [7,7,7,7,7]
        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    // 找到处于当前的位置
                    if (nums1[i] == nums2[j]) {
                        if (j == nums2.length - 1) {
                            // 当前正好处于最后一个数
                            result[i] = -1;
                        } else {
                            // 往后找到第一个比它大的数
                            result[i] = -1;
                            for (int k = j + 1; k < nums2.length; k++) {
                                if (nums1[i] < nums2[k]){
                                    result[i] = nums2[k]; // 将第一个大于它的值赋给result。
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
