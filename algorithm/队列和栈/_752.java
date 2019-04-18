package algorithm.队列和栈;

import java.util.*;

/**
 * 752. 打开转盘锁
 *
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class _752 {

    private int openLock(String[] deadends, String target) {

        // 解题思路：首先从start = "0000"开始，因为每次只能移动1位数字，所以这里就可以列举出所有的相邻的变化的节点，然后再判断列举出来的节点中
        // 是否包含在dead节点中和是否被遍历过了。
        // 思维需要变化一下，这里是把"0000"当做一个节点，然后每次变化1位，也就是列举出相邻的节点，比如：9000，1000，0900，0100

        // dead节点可能包含重复的节点，所以可以用set集合来删除重复的节点
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();// 用来判断是否浏览过了

        String start = "0000";
        // 如果dead中直接包含了start节点和目标节点，那么就可以直接返回-1了
        if (dead.contains(start) || dead.contains(target)){
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        int step = 0;
        queue1.offer(start);//添加起始点
        while (!queue1.isEmpty()){
            // 提取出当前的密码
            String cur = queue1.poll();
            if (target.equals(cur)){
                // 如果正好是目标密码
                return step;
            }
            // 如果不是目标密码，那么就需要利用BFS广度优先搜索，从起始节点开始，进行搜索了
            List<String> nexts = getNextNode(cur);
            // 然后对这些所有节点进行判断
            for (String next : nexts){
                if (!visited.contains(next) && !dead.contains(next)){
                    // 如果没有浏览过并且不包含在死亡锁之中
                    visited.add(next);
                    queue2.offer(next);
                }
            }

            // 这里解释一下，为什么到这里才算一步，因为，通过getNextNode方法，是获取到所有的情况，也就说明下一步将会出现这些可能的情况
            // 说不定这其中就有一种情况满足了target了呢，所以就是当队列为空的时候，也就是这种情况完全都不满足，也就算1步
            if (queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();
                step++;
            }
        }

        return -1;

    }

    /**
     * 获取某个节点后的所有节点
     *
     * @param cur
     * @return
     */
    private List<String> getNextNode(String cur){
        List<String> result = new ArrayList<>();

        // 4位数密码，依次向前或者向后移动1位，然后添加到集合中，这也就是相当于从起始点开始进行搜索
        for (int i = 0; i < 4; i++){
            // 这里需要处理0 和 9 之间的跳转
            StringBuilder sb = new StringBuilder(cur);
            sb.setCharAt(i,cur.charAt(i) == '9' ? '0':(char)(cur.charAt(i) + 1));
            result.add(sb.toString());
            sb.setCharAt(i, cur.charAt(i) == '0'? '9' : (char)(cur.charAt(i) - 1));
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args){
        _752 p = new _752();
        System.out.println(p.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }

}
