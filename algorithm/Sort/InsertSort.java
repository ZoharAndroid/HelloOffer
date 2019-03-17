package algorithm.Sort;

/**
 * 直接插入排序算法
 *
 * 插入排序的思想就是：
 * 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 *
 * 代码中是从索引1开始的，也就是相当于把索引0的值当做初始有序的值的第一个，然后每次从待排序的数组中取一个数，到已经排好序的数组中
 * 进行插入。
 *
 * @param <T>
 */
public class InsertSort<T extends Comparable<T>>  extends Sort<T>{

    /**
     * while循环方法
     *
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        for (int i = 1; i < nums.length; i++){
            int j = i;// 从第1为开始比较
            while (j > 0 && less(nums[j], nums[j - 1])){
                // 如果当前的值比前面的值小，就交换两者的值
                swap(nums,j, j-1);
                j--;
            }
        }
    }


    /**
     * for循环写法
     *
     * @param nums
     */
    public void sort1(T[] nums){
        for (int i = 1; i < nums.length; i++){
            for (int j = i; j > 0 && less(nums[j],nums[j - 1]); j--){
                swap(nums, j, j - 1);
            }
        }
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args){
        InsertSort sort = new InsertSort();
        Integer[] array = new Integer[]{5,1,3,2,7,6};
        sort.sort1(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
