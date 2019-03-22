package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题31：栈的压入 、弹出序列
 *
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 */
public class Problem31 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 定义一个数据缓冲栈
        ArrayList<Integer> dataList = new ArrayList<>();

        int n = pushA.length;//记录压入栈的长度
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++){
            // 遍历压入栈的元素，然后亚弱到缓存列表中
            dataList.add(pushA[pushIndex]);
            while (popIndex < n && popA.length != 0 && popA[popIndex] == dataList.get(dataList.size() - 1)){
                // 只要弹出栈的顶部元素与缓存队列的顶部元素相等，就弹出缓存数据列表中的元素
                dataList.remove(dataList.size() - 1);
                // 移动到下一个弹出栈的数据元素位置
                popIndex++;
            }
        }

        // 如果缓存数据全部完毕，那么说明弹出栈是压入栈的弹出序列
        return dataList.isEmpty();
    }
}
