package algorithm.队列和栈;


/**
 * 739. 每日温度
 *
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739 {

    private int[] dailyTemperatures(int[] T) {

        // 解题思路：遍历这个数组，然后依次判断后面的数据是否比这个数大
        // 如果比这个数大，那么就填入相差的值，
        // 如果比这个数小，那么继续移动
        // 这里需要注意的是，最后一个数一定为0

        if (T.length == 1){
            // 如果只有1个温度值，那么就直接返回0就行了
            return new int[0];
        }

        int[] result = new int[T.length];
        for (int i = 0; i < T.length - 1; i++){
            int days = 1; // 天数
            for (int j = i + 1; j < T.length; j++){
                if (T[i] >= T[j]){
                    // 知道温度身高
                    days++;
                }else{
                    // 跳出当前循环
                    //days = j - i;
                    break;
                }
            }

            if (days == result.length - i){
                result[i] = 0;
            } else{
                result[i] = days;
            }
        }
        result[result.length - 1] = 0;

        return result;

    }

    public static void main(String[] args){
        _739 p = new _739();
        int[] result = p.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
