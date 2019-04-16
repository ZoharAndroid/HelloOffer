package algorithm.数组和字符串;

/**
 * 344. 反转字符串
 */
public class _344 {

    /**
     * 利用两个指针，分别指向开始位置和最后位置，然后进行交换，直到两个相遇，也代表两个交换完毕了
     *
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }

        int start = 0;
        int end = s.length - 1;
        while ( start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args){
        char[] s = new char[]{'h','e','l','l','o'};
        _344 p = new _344();
        p.reverseString(s);
        System.out.println(String.valueOf(s));
    }
}
