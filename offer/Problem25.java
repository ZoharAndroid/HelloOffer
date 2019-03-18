package offer;

/**
 * 面试题25：合并两个排序的链表
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem25 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            // list1链表为空那么就返回list2
            return list2;
        }else if (list2 == null){
            // list2 链表为空，那么就返回 list1
            return list1;
        }

        //创建一个新的头节点
        ListNode mergeHead = null;

        if (list1.m_nValue > list2.m_nValue){
            // 如果当前的 list1 节点值 大于 list2节点的值，那么就把list2赋值给mergerHead
            mergeHead = list2;
            // 然后递归调用
            mergeHead.m_nextNode = Merge(list1, list2.m_nextNode);
        }else{
            // 同理可以写出如下代码
            mergeHead = list1;
            mergeHead.m_nextNode = Merge(list1.m_nextNode, list2);
        }

        return mergeHead;
    }
}
