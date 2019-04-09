package offer;

/**
 *
 * 面试题53_2：0 ~ n-1中缺失的数字
 */
public class Problem53_2 {

    public int GetMissingNumber(int[] array){
        if (array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if (array[mid] != mid){
                // 如果当前的数组与下标不相等的话，然后判断是否是第一个不相等的，那么此时就需要判断前面的是否是不相等的，
                // 如果是相等的，那么，说明就是当前mid就是第一个出现不相等的，如果不相等，说明还在前面出现第一个不相等的
                if (mid == 0 || array[mid -1] == mid -1){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else{
                // 如果下标和值相等，说明出现下标和值不相等的在后半部分
                start = mid + 1;
            }
        }

        if (end == array.length-1){
            // 如果缺失的是最后一个数字
            return array.length;
        }

        return -1;
    }


    public static void main(String[] args){
        Problem53_2 p = new Problem53_2();
        System.out.println(p.GetMissingNumber(new int[]{ 1, 2, 3, 4, 5}));// 0
        System.out.println(p.GetMissingNumber(new int[]{ 0, 1, 2, 3, 4 }));// 5
        System.out.println(p.GetMissingNumber(new int[]{ 0, 1, 2, 4, 5 }));// 3
        System.out.println(p.GetMissingNumber(new int[]{ 1 }));// 0
        System.out.println(p.GetMissingNumber(new int[]{ 0 }));// 1
    }
}
