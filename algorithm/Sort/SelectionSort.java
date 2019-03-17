package algorithm.Sort;

/**
 * 选择排序法
 *
 * 每次排序选择最小的数依次移动到前面的位置。比如第一次排序就会把最小的值域索引为0的值进行交换，第二次排序，就在剩下的数中继续找最小的
 * 值，然后将这个值与索引为1的值进行交换。然后依次这样循环下去，直到最有一个数。
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++){
            int min = i; // 每次将最小值设置为开头的位置
            for (int j = i + 1; j < length; j++){
                if (less(nums[j], nums[min])){
                    // 比较当前值与最小值，如果小于最小值，那么重新设定最小值
                    min = j;
                }
            }

            //如果min值发生了变化，那么进行交换
            if (i != min){
                swap(nums, i, min);
            }
        }
    }


    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args){
        SelectionSort sort = new SelectionSort();
        Integer[] array = new Integer[]{5,1,3,2,7,6};
        sort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
