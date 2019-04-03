package offer;

import java.util.PriorityQueue;

/**
 * 面试题41：数据流中的中位数
 *
 */
public class Problem41 {

    // 最大堆（最上面的是最大的）
    PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
    // 最小堆(默认，最上面是最小的)
    PriorityQueue<Integer> right = new PriorityQueue<>();


    // 统计数据流中数据的个数
    int count = 0;

    public void Insert(Integer num) {

        if (count % 2 == 0){
            // 如果当前的个数为偶数个，说明就要处理一下最大堆中的数据，需要把最大堆中的一个数放入到最小堆中
            left.add(num);
            right.add(left.poll());
        }else{
            // 如果为奇数，说明要处理一下最小堆中的数据，把最小堆中的顶部元素，也就是最小值放入到最大堆中，以保证，右边的right堆都大于左边的left的堆
            right.add(num);
            left.add(right.poll());
        }

        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0){
            // 如果是偶数，就需要取最大堆和最小堆中顶部元素的平均数
            return (double)(left.peek() + right.peek())/2.0;
        }else{
            // 如果为奇数，则直接返回最小堆中的顶部元素
            return (double)(right.peek());
        }
    }
}
