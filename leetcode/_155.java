

import java.util.Stack;

public class _155 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

	static class MinStack {

		private Stack<Integer> stack;
		private int min;

		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<>();
			min = Integer.MAX_VALUE;
		}

		public void push(int x) {
			if (x <= min) {
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}

		public void pop() {
			if (min == stack.peek()) {
				stack.pop();
				min = stack.pop();
			} else {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				min = Integer.MAX_VALUE;
			}
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

	/**
	 * Your MinStack object will be instantiated and called as such: MinStack obj =
	 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
	 * = obj.getMin();
	 */

}
