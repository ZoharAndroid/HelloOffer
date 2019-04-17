package algorithm.队列和栈;

/**
 * 622. 设计循环队列
 *
 * https://leetcode-cn.com/problems/design-circular-queue/
 *
 */
public class _622 {

    static class MyCircularQueue {

        private Integer[] data;
        private int head;
        private int tail;
        private int curSize;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.data = new Integer[k];
            this.head = 0; // 表示队列的起始位置
            this.tail = -1; // 表示队列的结束位置
            this.curSize = 0; // 当前数组的个数
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            // 首先应该先判断该队列是否满了，如果满了入队失败，如果没满就加入队列中
            if (this.isFull()) {
                return false;
            }

            if (tail == data.length - 1) {
                // 移动到了末尾的位置
                data[0] = value ; // 重新移到开头的位置
                tail = 0; // 末尾置位0
            }else{
                // 如果tail位于其他的位置
                data[++tail] = value;
            }
            curSize++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            // 出队：首先判断队列是否为空，如果为空，出队失败，如果不为空，移除队列中的元素
            if (this.isEmpty()) {
                return false;
            }

            if (head == data.length - 1){
                // 如果head置于末尾的位置，就需要移动到开头的位置
                head = 0;
            }else{
                head++;
            }
            curSize--;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return data[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return data[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return curSize == 0 ? true : false;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return curSize == data.length  ? true : false;
        }

    }


    /**
     * ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
     * [[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]
     * @param args
     */
    public static void main(String[] args){
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.print(circularQueue.Rear()); // 2
        System.out.print(circularQueue.Front());
        //System.out.println(circularQueue.enQueue(2));  // 返回 true

        //System.out.println(circularQueue.enQueue(3));  // 返回 true

        //System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满

        //System.out.println(circularQueue.Rear());  // 返回 3

        //System.out.println(circularQueue.isFull());  // 返回 true

        //System.out.println(circularQueue.deQueue());  // 返回 true

        //System.out.println(circularQueue.enQueue(4));  // 返回 true

        //System.out.println(circularQueue.Rear());  // 返回 4

        //System.out.print(circularQueue.Front()); // 返回1
    }
}
