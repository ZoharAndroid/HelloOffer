public class Problem10_3 {

    /**
     * 面试题10  --  拓展
     *
     * @param target
     * @return
     *
     * 这题想法就是和题目而相同
     */
    public int JumpFloorII(int target) {
        if(target == 0){
            return 0;
        }else if(target== 1 || target == 2){
            return target;
        }else{
            return 2 * JumpFloorII(target - 1);
        }
    }
}
