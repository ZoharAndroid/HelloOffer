public class Problem10_1 {

    /**
     * 面试题10
     * 题目1：斐波拉契数列
     * 时间复杂度O(n)
     * @param n
     * @return
     *
     * 解题思路：
     *  用循环，每次求出中间值，然后暂存一下，在进行一下次循环。
     */
    public int Fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int[] fs = {f0,f1};
        if (n < 2){
            return fs[n];
        }
        int fn = 0;
        for (int i = 2; i <= n; i++){
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    /**
     * 使用递归方法
     *
     * @param n
     * @return
     */
    public int Fibonacci2(int n){
        if(n == 0) {
            return 0;
        } else if (n == 1){
            return 1;
        }else{
            return Fibonacci2(n-1) + Fibonacci2(n-2);
        }
    }

    public static void main(String[] args){
        Problem10_1 p = new Problem10_1();
        System.out.println(p.Fibonacci(40));
        System.out.println(p.Fibonacci2(40));
    }
}
