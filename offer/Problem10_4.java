package offer;

public class Problem10_4 {

    /**
     * 面试题10：
     * 相关题目：覆盖矩形
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target <= 2 ){
            return target;
        }
        int f0 = 1;
        int f1 = 2;
        int result = 0;
        for(int i = 3; i <= target; i++){
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;

    }
}
