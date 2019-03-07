package offer;

public class Problem10_2 {
    /**
     * 面试题10
     * 题目2 ： 青蛙跳台阶问题。
     * @param target
     * @return
     *
     * 解题思路：
     *  递归实现，就是斐波拉契问题
     */
    public int JumpFloor(int target){
        if(target == 0){
            return 0;
        }else if(target == 1||target == 2){
            return target;
        }else{
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }


    /**
     *  方法二：
     * @param target
     * @return
     * 解题思路：
     *      f(n) = f(n-1) + f(n-2)+...+f(1)
     *      f(n-1) = f(n-2) + f(n-3)+...+f(1)
     *      两式相减：f(n) = 2 * f(n - 1)
     */
    public int JumpFloor2(int target){
        if(target == 0){
            return 0;
        }else if(target == 1||target == 2){
            return target;
        }else{
            return 2 * JumpFloor2(target - 1);
        }
    }

    public static void main(String[] args){

    }
}
