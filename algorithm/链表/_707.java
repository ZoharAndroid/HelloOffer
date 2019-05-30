package algorithm.链表;

/**
 * 707. 设计链表
 *
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class _707 {

    static class MyLinkedList {

        private static class Node{
            private Node next;
            private int val;

            public Node(int val, Node next){
                this.val = val;
                this.next = next;
            }
        }

        private int size; // 当前链表的数目
        private Node head;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= this.size){
                return -1;
            }

            Node temp = this.head;
            // 遍历到这个index
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }

            return temp.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            this.head = new Node(val, this.head);
            this.size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            // 如果没有
            if (this.size == 0){
                this.head =  new Node(val, null);
            }else {
                // 遍历到末尾
                Node temp = this.head;
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = new Node(val, null);
            }
            this.size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > this.size ){
                return;
            }


            if (index <= 0){
                addAtHead(val);
            }else{
                Node temp = this.head;
                for (int i = 0; i < index - 1; i++){
                    temp = temp.next;
                }
                Node node = new Node(val,temp.next);
                temp.next = node;
                this.size++;
            }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= this.size  || index < 0){
                return;
            }

            if (index == 0){
                // 删除头节点
                this.head = this.head.next;
                this.size--;
            }else{
                Node temp = this.head;
                for (int i = 0; i < index - 1; i++){
                    temp = temp.next; // 移动到index前面的节点
                }

                temp.next = temp.next.next;
                this.size--;
            }
        }
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
//        System.out.println(linkedList.get(0));
//        linkedList.addAtIndex(1,2);
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.get(1));
//        linkedList.addAtIndex(0,1);
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.get(1));



        linkedList.addAtHead(1);
        System.out.println(linkedList.get(0));
        linkedList.addAtTail(3); // 1 -> 3
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(1,2); // 1 -> 2 -> 3
        System.out.println(linkedList.get(1));  // 2
        linkedList.deleteAtIndex(1); // 1 -> 3
        System.out.println(linkedList.get(1)); // 3
    }

}
