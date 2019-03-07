package offer;


/**
 * 面试题11
 * 旋转数组中的最小值
 * 利用二分查找的原理和顺序查找来找到最小值。
 */
public class Problem11 {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            throw new Error();
        }

        int indexStart = 0;
        int indexEnd = array.length - 1;
        int indexMid = indexStart;

        while (array[indexStart] >= array[indexEnd]){

            if (indexEnd - indexStart == 1){
                indexMid = indexEnd;
                break;
            }

            indexMid = (indexStart + indexEnd)/2;

            // 如果下标indexStart、indexEnd 和 indexMid三个所指的数据都相等，那么就应该考虑用顺序查询了，而不是再考虑用二分查找方法了
            if (array[indexStart] == array[indexEnd] && array[indexStart] == array[indexMid]){
                // 考虑用顺序查找方法
                return inOrderSearch(array,indexStart,indexEnd);
            }

            if (array[indexMid] >= array[indexStart]){
                // 大于起始值，说明还是在递增的数组
                indexStart = indexMid;
            }else if(array[indexMid] <= array[indexEnd]){
                // 小于后面的数据，说明在后面递增的数组中
                indexEnd = indexMid;
            }
        }

        return array[indexMid];
    }

    private int inOrderSearch(int[] array,int index1, int index2){
        int result = array[index1];

        for (int i = index1; i <= index2; i++){
            if (result > array[i]){
                result = array[i];
            }
        }

        return  result;
    }

    public static void main(String[] args){
        Problem11 p = new Problem11();
        int[] array1 = {3,4,5,1,2};
        int[] array2 = {1,0,1,1,1};
        System.out.println(p.minNumberInRotateArray(array2));
    }
}
