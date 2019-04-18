# 数据结构和算法


## 数组和字符串

[知识储备/学习链接](https://leetcode-cn.com/explore/learn/card/array-and-string/)

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

LeetCode中的题目练习：
### 数组
1. [724 寻找数组的中心索引](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_724.java)
2. [747 至少是其他数字两倍的最大数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_747.java)
3. [66 加1](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_66.java)

### 二维数组
1. [498 对角线遍历](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_498.java)
2. [54 螺旋矩阵](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_54.java)
3. [118 杨辉三角](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_118.java)

### 字符串
1. [67 二进制求和](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_67.java)
2. [28 实现strStr()](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_28.java)
3. [14 最长公共前缀](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_14.java)

### 双指针1
1. [344 反转字符串](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_344.java)
2. [561 数组拆分I](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_561.java)
3. [167 两数之和II-输入有序数组](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_167.java)

### 双指针2
1. [27 移除元素](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_27.java)
2. [485 最大连续1的个数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_485.java)
3. [209 长度最小的子数组](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_209.java)

### 本章小结
1. [189 旋转数组](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_189.java)
2. [119 杨辉三角II](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_119.java)
3. [151 翻转字符串里的单词](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_151.java)
4. [557 反转字符串中的单词III](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_557.java)
5. [26 删除排序数组中的重复项](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_26.java)
6. [283 移动零](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E6%95%B0%E7%BB%84%E5%92%8C%E5%AD%97%E7%AC%A6%E4%B8%B2/_283.java)

## 队列和栈

[知识储备/学习链接](https://leetcode-cn.com/explore/learn/card/array-and-string/)

队列：先入先出（FIFO），栈：后入先出（LIFO）。

队列基本问题（BFS 广度优先搜索）,栈基本问题（DFS 深度优先搜索）

### 队列：先入先出的数据结构
1. [622 设计循环队列](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_622.java)

### 队列和广度优先搜索
1. [200 岛屿的个数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_200.java)
2. [752 打开转盘锁](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_752.java)

### 栈：后入先出的数据结构
1. [155 最小栈](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_155.java)
2. [20 有效的括号](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_20.java)
3. [739 每日温度](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_739.java)
4. [150 逆波兰表达式求值](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_150.java)

### 栈和深度优先搜索
1. [200 岛屿的个数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_200.java)