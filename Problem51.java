public class Problem51 {

    public int InversePairs(int [] array) {

        if (array == null || array.length == 0){
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }

        long count = mergerSort(array, copy, 0, array.length - 1);
        return (int)(count % 1000000007);
    }

    private long mergerSort(int[] array, int[] copy, int start, int end){
        // 如果start与end相遇
        if(start == end){
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start)/2;

        long left = mergerSort(copy, array, start, start + length);
        long right = mergerSort(copy, array, start + length + 1, end);

        int i = start + length; // 将i初始化为前半段最后一个索引位置
        int j = end; // 将j初始化为后半段最后一个索引位置
        int indexCopy = end; // 辅助数组中的索引指向最后面位置
        long count = 0;

        while (i >= start &&  j >= start+length + 1 ){
            if (array[i] > array[j]){
                // 如果前面的数子大于后面的数子
                copy[indexCopy--] = array[i--]; // array中的前半部分的数字添加到辅助数组中，并且索引向前移动
                count += j - start - length; // 因为前半部分的这个数字都大于后半部分，所以，就是后半部分的数字有多少个，逆序数就加多少
            }else{
                // 如果后半部分的数字大于前半部分，那么就没有逆序数，就直接添加到辅助数组中，然后修改索引
                copy[indexCopy--] = array[j--];
            }
        }


        for (; i >= start; --i){
            copy[indexCopy--] = array[i];
        }

        for (; j >= start+length+1; --j){
            copy[indexCopy--] = array[j];
        }

        return left + right + count;
    }

    public static void main(String[] args){
        Problem51 p = new Problem51();
        System.out.println(p.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
