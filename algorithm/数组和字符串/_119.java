package algorithm.数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class _119 {

    private List<Integer> getRow(int rowIndex) {

        // 解题思路：杨辉三角，第几行就有几个数，要知道下面一行的数，就必须要知道上面一行的数，所以就需要保存上面一行的数。
        // 注意，这一题与“杨辉三角1”有点不同，就是题目要求输出的结果索引从0开始

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowResult = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++){
            // 一种需要求多少行
            rowResult = new ArrayList<>(); // 用于保存每行的结果
            for (int j = 1; j <= i; j++){
                if (j == 1){
                    rowResult.add(1);
                }else if (j == i && j != 1){
                    rowResult.add(1);
                }else{
                    rowResult.add(result.get(i - 2).get(j - 2) + result.get(i-2).get(j - 1));
                }
            }
            result.add(rowResult);
        }
        return rowResult;
    }

    public static void main(String[] args){
        _119 p = new _119();
        System.out.println(p.getRow(3));
    }
}
