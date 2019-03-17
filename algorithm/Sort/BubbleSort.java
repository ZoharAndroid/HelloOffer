package algorithm.Sort;

/**
 * 冒泡排序算法
 *
 * 依次比较相邻的两个数，
 *
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        boolean flag = false;
        for (int i = length - 1; i > 0 && !flag; i--){
            flag = false;
            for (int j = 0; j < i; j++){
                flag = true; // 如果循环了饿一轮都没有改变这个状态值，说明数组是有序的，所以就不用再继续进行比较了
                if (less(nums[j + 1], nums[j])){
                    flag = false;//改变状态
                    swap(nums, j, j+1);
                }
            }
        }
    }


    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args){
        BubbleSort<Integer> sort = new BubbleSort<>();
        Integer[] array = new Integer[]{5,1,3,2,7,6};
        sort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
