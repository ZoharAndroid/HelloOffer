

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _225 {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 使用的是队列Queue
	 * 
	 * @author zohar
	 *
	 */
	static class MyStack2 {

		Queue<Integer> queue = new LinkedList<>();
	    /** Initialize your data structure here. */
	    public MyStack2() {
	        
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.offer(x);
	        for (int i = 1; i < queue.size(); i++) {
				queue.offer(queue.remove());
			}
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        return queue.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	
	
	/**
	 * 使用的是list
	 * @author zohar
	 *
	 */
	static class MyStack {
		
		List<Integer> list = new ArrayList<>();

	    /** Initialize your data structure here. */
	    public MyStack() {
	        
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        list.add(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        return list.remove(list.size() -1 );
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return list.get(list.size() - 1);
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return list.isEmpty();
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
