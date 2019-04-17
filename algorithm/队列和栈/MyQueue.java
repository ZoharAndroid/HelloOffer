package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private List<Integer> list;
    private int index;

    public MyQueue(){
        list = new ArrayList<>();
        index = 0;
    }

    /**
     * 入队
     *
     * @param x
     * @return
     */
    public boolean enQueue(int x){
        list.add(x);
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean deQueue(){
        if (list.isEmpty()){
            return false;
        }

        // 移动指针
        index++;
        return true;
    }

    /**
     * 获取头部元素
     *
     * @return
     */
    public int Front(){
        return list.get(index);
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return index >= list.size();
    }
}
