package algorithm.二分查找;

/**
 * 33. 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _33 {

    public int search(int[] nums, int target) {

        // 解题思路：用双指针，移动到两者的间隔点，也就分为两个部分了。如果目标值在那个部分就在哪个部分用二分查找来寻找

        if (nums == null || nums.length == 0){
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex){
            if (nums[leftIndex] < nums[rightIndex]){
                break;
            }
            rightIndex--;
        }
        // 到这里也就分为了两个部分了[0,rightLeft] 和 [ rightLeft, nums.length]
        // 判断target位与那个部分
        if (target >= nums[0] && target <= nums[rightIndex]){
            // 前半部分
            return binarySearch(nums,0,rightIndex,target);
        }else{
            // 后半部分
            return binarySearch(nums, rightIndex + 1, nums.length -1,target);
        }

    }

    private int binarySearch(int[] nums,int startIndex, int endIndex, int target){
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (nums[midIndex] == target){
                return midIndex;
            }else if (nums[midIndex] > target){
                endIndex = midIndex - 1;
            }else{
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        _33 p = new _33();
        System.out.println(p.search(new int[]{}, 3));
    }
}
