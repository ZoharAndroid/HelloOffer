import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//429.N叉树的层序遍历
public class _429 {
	public static void main(String[] args) {
		
	}
	
	class Solution {
		/**
		 * 解题思路：每次用Queue储存节点的子节点，然后再读取子队列中的val值并添加在list中
		 * 
		 * @param root
		 * @return
		 * 
		 * 执行用时: 10 ms, 在N-ary Tree Level Order Traversal的Java提交中击败了53.03% 的用户
		 */
	    public List<List<Integer>> levelOrder(Node root) {
	    	List<List<Integer>> result = new ArrayList<>();
	        if (root == null) {
				return result;
			}
	        
	        Queue<Node> queue = new LinkedList<>();
	        //首先将root节点加入队列中
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	        	//不为空
	        	List<Integer> list = new ArrayList<>();
	        	int size = queue.size();
	        	for (int i = 0; i < size; i++) {
	        		Node currentNode = queue.poll();
					list.add(currentNode.val);
					//接下来把该节点的子节点保存在队列中，以便循环读取
					for (Node childNode : currentNode.children) {
						queue.offer(childNode);
					}
				}
	        	result.add(list);
	        }
	        return result;
	    }
	}
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
}
