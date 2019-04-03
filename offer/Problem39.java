package offer;

/**
 * 面试题39：数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Problem39 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        int value = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++){
            if (value == array[i]){
                // 如果的值与数组中的值相等的话，那么计数+1，否则 -1；
                count++;
            }else{
                count--;
            }
            // 如果count计数为0，说明前面的数和当前的数不相同，那么就换一个，并且重置计数count值。
            if (count == 0){
                value = array[i];
                count = 1;
            }
        }

        count = 0;
        for (int val : array){
            if (val == value){
                count++;
            }
        }

        if (count > array.length / 2){
            return value;
        }else{
            return 0;
        }
    }


    public static void main(String[] args){
        Problem39 p = new Problem39();
        System.out.println(p.MoreThanHalfNum_Solution(new int[]{4,2,1,4,2,4}));
    }
}
