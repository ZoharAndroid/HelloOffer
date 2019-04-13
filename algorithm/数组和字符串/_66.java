package algorithm.数组和字符串;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class _66 {
    // 不要转换成int/long型再去处理，直接对最后一位进行处理
    public int[] plusOne(int[] digits) {
        // 处理最后1位
        int lastIndex = digits.length - 1;
        boolean carry = false; // 进位
        if (digits[lastIndex] == 9){
            // 如果当前的最后1位为9，那么加1之后，就会有进位产生
            carry = true; // 有进位
            digits[lastIndex] = 0; // 最后1位置位0
        }else{
            // 如果是其他位，那么直接加上1然后就可以返回了
            digits[lastIndex]+= 1;
            return digits;
        }

        //带有进位了，就需要处理其他位上的数字了
        for (int i = lastIndex - 1; i >= 0; i--){
            if (carry){
                // 如果有进位
                if (digits[i] == 9) {
                    // 如果前面的数字为9，并且有进位，那么就需要置当前为0
                    carry = true;
                    digits[i] = 0;
                }else{
                    // 如果当前数组不为9，那么就直接加上1然后返回
                    carry =  false;
                    digits[i]+=1;
                    return digits;
                }
            }
        }

        // 进过上面的处理，如果有进位并且第一位为0，那么就可以判断长度需要增加1，并且设置为1
        if (carry && digits[0] == 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++){
                result[i] = digits[i - 1];
            }
            return result;

        }

        return digits;
    }

    public static void main(String[] args){
        _66 p = new _66();
        p.plusOne(new int[]{7,2});
    }
}
