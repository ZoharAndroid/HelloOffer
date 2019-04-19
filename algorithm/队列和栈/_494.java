package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 494. 目标和
 *
 * https://leetcode-cn.com/problems/target-sum/
 */
public class _494 {

    private int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        return find(nums, 0 , S);
    }

    private int find(int[] nums, int index, int sum){
        if (index == nums.length ){
            if (sum == 0){
                return 1;
            }else{
                return 0;
            }
        }
        return find(nums, index+1, sum - nums[index]) + find(nums, index + 1,sum + nums[index]);
    }

    // 该方法超时
    private int findTargetSumWays1(int[] nums, int S) {

        // 解题思路：从顶部端点0开始，分别以+1 和 -1 两个分支展开，一直到最后的叶子节点，判断最后的数据中有多少是包含目标的值。

        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1 && (nums[0] == S || -nums[0] == S)){
            return 1;
        }

        List<List<Integer>> result = new ArrayList<>(); // 用于保存整个树处理的结果
        List<Integer> rowResult = new ArrayList<>();
        int postive = nums[0];
        int negtive = -nums[0];
        rowResult.add(postive);
        rowResult.add(negtive);
        result.add(rowResult);
        for (int i = 1; i < nums.length; i++){
            rowResult = new ArrayList<>(); // 每一行的结果
            for (int j = 0; j < result.get(i - 1).size(); j++){
                int cur = result.get(i - 1).get(j); // 获取上一行的数
                int temp1 = cur + nums[i]; // +
                int temp2 = cur - nums[i]; // -
                rowResult.add(temp1);
                rowResult.add(temp2);
            }
            result.add(rowResult);
        }

        // 获取最后一行的数据，判断有多少个是等于目标值得
        int count = 0;
        for (int i = 0; i < result.get(nums.length - 1).size(); i++){
            if (result.get(nums.length - 1).get(i) == S){
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args){
        _494 p = new _494();
        System.out.println(p.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
