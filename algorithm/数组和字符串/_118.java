package algorithm.数组和字符串;

import java.util.ArrayList;
import java.util.List;

public class _118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rows;

        // 第一行1个数，第二行2个数，第三行3个数。。。以此类推，numRows就有Rows行个数
        // 并且每行两边的数都是1
        for (int i = 1; i <= numRows; i++ ){
            rows = new ArrayList<>();// 第i行
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    rows.add(1);
                } else if (j == i && i != 1) {
                    rows.add(1);
                } else {
                   rows.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
                }
            }
            result.add(rows);
        }

        return result;
    }

    public static void main(String[] args){
        _118 p = new _118();
     //   List<List<Integer>> result  = p.generate(5);

        System.out.println(p.generate(5));
    }
}
