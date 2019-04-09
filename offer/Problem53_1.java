package offer;


/**
 * 面试题53_1：在排序数组中查找数字
 *
 */
public class Problem53_1 {

    public int GetNumberOfK(int[] array , int k) {

        int number = 0;

        if (array != null && array.length != 0){
            int first = getFirstK(array,k,0, array.length-1);
            int last = getLastK(array, k, 0, array.length - 1);


            if (first > -1 && last > -1){
                number = last - first + 1;
            }
        }

        return number;

    }

    private int getFirstK(int[] array, int k, int start, int end){
        if (start > end){
            return -1;
        }

        int mid = start + (end - start)/2;
        int midData = array[mid];

        if (midData == k){
            // 如果中间数据等于k，那么就需要判断中间数据的前面部分是否是与K还是相同的，
            // 如果还是相同的，那么中间索引就需要向前移动，这里需要注意的是，如果中间数据直接位于第一个，那么就直接返回当前位置了
            if ((mid > 0 && array[mid - 1] !=k) || mid == 0){
                return mid;
            }else{
                // 如果不是位于第一个位置，或者与前面的值相等的时候，说明，第一个与k相等的值还在前半部分
                end = mid - 1; // 修改判断的区间
            }
        }else if (midData > k){
            // 如果中间数值大于K，说明k值还在前半部分
            end = mid - 1;
        }else{
            start = mid + 1; // 在后半部分
        }

        return getFirstK(array, k , start, end); // 不断递归调用，知道直到找到第一个出现的k值得位置。
    }

    /**
     * 找到最后一个相同的K值
     *
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getLastK(int[] array, int k, int start, int end){
        if (start > end ){
            return -1;
        }

        int mid = start + (end - start)/2;
        int midData = array[mid];

        if (midData == k){
            if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1){
                // 如果不位于最后一个并且不等于k，或者是最后一个，那么说明当前找到的就是最后一个k值得位置
                return mid;
            }else {
                start = mid + 1;
            }
        }else if (midData > k){
            // 如果中间数值大于k，那么说明中间的数子在前半部分
            end = mid - 1;
        }else{
            start = mid + 1;
        }

        return getLastK(array, k, start, end);
    }


    public static void main(String[] args){
        Problem53_1 p = new Problem53_1();
        System.out.println(p.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 6}, 3));
    }
}
