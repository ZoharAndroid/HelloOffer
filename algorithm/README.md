# 数据结构和算法

## 数组和字符串

### 动态数组
```$xslt
package algorithm.数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args){
        // 1. 初始化
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;
        // 2. 数组转换成动态数组
        Integer[] a = {0,1,2,3,4};
        v1 = new ArrayList<>(Arrays.asList(a)); // 这里必须先把a转换成集合的形式才能通过ArrayList构造方法转换成动态数组
        // 3. 复制
        List<Integer> v2 = v1; // 把引用复制，其实两个指向的是同一个地址
        List<Integer> v3 = new ArrayList<>(v1);// 新创建了一个对象
        // 4. 获取元素
        System.out.println("第一个元素为：" + v1.get(0)); // 0
        // 5. 修改
        v2.set(0, 10);
        System.out.println(v1.get(0)); // 10, 这里修改v2也就是修改v1
        v3.set(0, 5);
        System.out.println(v1.get(0)); // 10, v3是new的对象，所以修改v3并不会修改v1了
        // 6. 排序
        Collections.sort(v1); // 默认递增
        for (int num : v1){
            System.out.print(num+ " ");
        }
        Collections.sort(v1,((o1, o2) -> o2 - o1)); // 递减
        // 7. 添加新的数据
        v1.add(-1);
        System.out.println(v1.get(v1.size() - 1));
        v1.add(2,20);
        for (int num: v1) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 8. 删除
        v1.remove(Integer.valueOf(-1)); // 可以删除对象
        for (int num: v1) {
            System.out.print(num + " ");
        }
        System.out.println();
        v1.remove(v1.size() - 1); // 也可以删除索引指定的
        for (int num: v1) {
            System.out.print(num + " ");
        }
    }
}
```


