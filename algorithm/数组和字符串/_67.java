package algorithm.数组和字符串;

public class _67 {

    /**
     * 从高位到低位，然后结果反转一下
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int carry = 0; // 进位标志
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        while ( indexA >= 0 || indexB >= 0){
            int sum = carry;
            if (indexA >= 0){
                sum+= a.charAt(indexA) - '0';
                indexA--;
            }

            if (indexB >= 0){
                sum += b.charAt(indexB) - '0';
                indexB--;
            }
            sb.append(sum%2);
            carry = sum /2;
        }

        if (carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
    /*
    public String addBinary(String a, String b) {
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();

        // 从低位相加，如果相加的结果为2，说明有进位
        boolean carry = false; // 进位
        // 判断哪个较长
        char[] longchars,shortchars;
        if (cha.length > chb.length){
            longchars = cha;
            shortchars = chb;
        }else{
            longchars = chb;
            shortchars = cha;
        }

        int[] result = new int[longchars.length];
        for (int i = 0; i < shortchars.length; i++){
            if (carry){
                result[i] =  longchars[i] - '0' + shortchars[i] - '0' + 1;
            }else {
                result[i] = longchars[i] - '0' + shortchars[i] - '0';
            }

            if (result[i] >= 2){
                result[i] = result[i] - 2;
                carry = true;
            }else{
                carry = false;
            }

        }

        // 接下来判断剩下来的
        for (int i = longchars.length - shortchars.length; i < longchars.length; i++){
            if (carry) {
                result[i] = result[i] + 1;
                if (result[i] >= 2) {
                    carry = true;
                    result[i] = result[i] - 2;
                } else {
                    carry = false;
                    return String.valueOf(result);
                }
            }
        }

        // 如果最后都还有进位标志
        int[] temp = new int[longchars.length + 1];
        if(carry) {
            temp[longchars.length] = 1;
            for (int i = longchars.length - 1; i >= 0; i--) {
                temp[i] = result[i];
            }
            return String.valueOf(temp);
        }

        return String.valueOf(result);
    }
    */

    public static void main(String[] args){
        _67 p = new _67();
        System.out.println(p.addBinary("11","1"));
    }
}
