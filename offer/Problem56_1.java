package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * // 面试题56（一）：数组中只出现一次的两个数字
 * // 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * // 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Problem56_1 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /**
     * 方法1： 使用异或来得到最右边不为0的位
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array,int num1[] , int num2[]) {

        int diff = 0;
        for (int num : array){
            diff ^= num;// 得到异或的结果
        }

        diff &= -diff; // 通过这个与相反数相与就可以得到最后边不为0的位
        for (int num : array){
            if ((num & diff) == 0){
                num1[0] ^= num;
            }else{
                num2[0] ^= num;
            }
        }
    }

    /**
     * method2：
     *
     * 用 Hashmap方法来处理，虽然能够解决问题，但是满足不了题目的要求的。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce2(int[] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0){
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i){
            map.put(array[i],map.getOrDefault(array[i], 0 ) + 1);
        }

        // 遍历map中寻找到为1的
        Object[] keys = map.keySet().toArray();
        int count = 2;
        for (int i = 0; i < keys.length; i++){
            if (map.get(keys[i]) == 1){
                if (count == 2){
                    num1[0] = (int)keys[i];
                    count--;
                }else{
                    num2[0] = (int)keys[i];
                }

            }
        }

        //System.out.println(num1[0] + " " + num2[0]);
    }

    public static void main(String[] args){
        Problem56_1 p = new Problem56_1();
        p.FindNumsAppearOnce2(new int[]{2, 4, 3, 6, 3, 2, 5, 5},new int[1], new int[1]);
    }
}
