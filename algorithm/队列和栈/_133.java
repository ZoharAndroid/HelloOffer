package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 *
 * https://leetcode-cn.com/problems/clone-graph/
 */
public class _133 {

    // 解题思路：首先从右一个节点出发，然后判断之前是否复制过这个节点的邻居节点，如果之前复制过了，那么就不用再去比搜索了，直接把之前的搜索结果
    // 也就是邻居节点添加过来，如果之前没有复制过，那么就需要继续搜索了。

    Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {

        if (node == null ){
            return null;
        }

        // 复制一个新的节点
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        // 判断邻居节点
        for (Node neighbor : node.neighbors){
            if (!map.containsKey(neighbor)){
                // 如果不包含邻居节点，说明这个节点还没有复制过
                Node newNeighbor = cloneGraph(neighbor);
                copy.neighbors.add(newNeighbor);
            }else{
                // 如果包含了邻居节点，说明复制过了，那么直接添加这个邻居节点的复制信息即可
                copy.neighbors.add(map.get(neighbor));
            }
        }

        return copy;
    }
}
