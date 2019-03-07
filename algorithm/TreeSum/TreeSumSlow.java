package algorithm.TreeSum;

/**
 * 这种方法的时间复杂度为O(n^3)，时间负载度查
 */
public class TreeSumSlow implements TreeSum {

    @Override
    public int count(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        count ++;
                    }

                }
            }
        }

        return count;
    }
}
