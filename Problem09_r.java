import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 添加：哪个队列数据就往那个队列中添加数据
 * 删除：那个队列为空，就往那个队列移动数据，然后再删除
 */
public class Problem09_r {
    Queue<Integer> q1 = new ArrayDeque<Integer>();
    Queue<Integer> q2 = new ArrayDeque<Integer>();

    public void push(int element){
        if (q1.isEmpty()){
            q1.add(element);
            return;
        }

        if (q2.isEmpty()){
            q2.add(element);
            return;
        }
    }

    public int pop(){
        if (q1.isEmpty()){
            while (q2.size() > 1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }

        if (q2.isEmpty()){
            while(q1.size() > 1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }

        return (Integer)null;
    }

}
