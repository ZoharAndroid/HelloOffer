package offer;

/**
 * 面试题42；连续子数组的最大和
 *
 */
public class Problem42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        int gestestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int value : array){
            // 判断当的sum值是否小于等于0，如果小于等于0，则sum重新赋值为当前值，否则，则一直相加，直到不小于0
            sum = sum <= 0 ? value : sum + value;
            // 比较最大值
            gestestSum = Math.max(gestestSum, sum);
        }

        return gestestSum;
    }


    public static void main(String[] args){
        Problem42 p = new Problem42();
        System.out.println(p.FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
    }

}
