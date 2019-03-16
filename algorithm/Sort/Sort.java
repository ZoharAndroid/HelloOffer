package algorithm.Sort;

/**
 * Sort抽象类
 *
 * 该类定义了抽象的方法sort。并且实现了less(T v, T w)方法来判断两个数的大小，这个less方法是利用
 * compareTo()方法来实现的。还实现了swap(T[] nums, int a, int b)方法来实现两个数在数组中的交换。
 *
 */
public abstract class Sort<T extends Comparable<T>> {

    /**
     * 排序方法
     *
     * @param nums
     */
    public abstract void sort(T[] nums);

    /**
     * 用于判断 v 是否 小于 w
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中的两个值
     *
     * @param nums 带交换的数组
     * @param a 数组索引位置a
     * @param b 数组中的索引位置b
     */
    protected void swap(T[] nums, int a, int b){
        T temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
