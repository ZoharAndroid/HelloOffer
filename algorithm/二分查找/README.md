# 二分查找

[知识储备/学习链接](https://leetcode-cn.com/explore/learn/card/binary-search/208/background/)

### 二分查找模板1

```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}

终止条件：left > right
```

1. [704 二分查找](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_704.java)
2. [69 x的平方根](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_69.java)
3. [374 猜数字大小](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_374.java)
4. [33 搜索旋转排序数组](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_33.java)

### 二分查找模板2

```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
终止条件： left == right
```

关键属性:

* 一种实现二分查找的高级方法。
* 查找条件需要访问元素的直接右邻居。
* **使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。**
* 保证查找空间在每一步中至少有 2 个元素。

1. [278 第一个错误的版本](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_278.java)
2. [162 寻找峰值](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_162.java)
3. [153 寻找旋转排序数组中的最小值](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_153.java)

### 二分查找模板3

```
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}

终止条件：left + 1 == right
``` 

关键属性:

* 实现二分查找的另一种方法。
* 搜索条件需要访问元素的直接左右邻居。
* 使用元素的邻居来确定它是向右还是向左。
* 保证查找空间在每个步骤中至少有 3 个元素。

1. [34 在排序数组中查找元素的第一个和最后一个位置](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_34.java)
2. [658 找到 K 个最接近的元素](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_658.java)

### 小结

1. [50 Pow(x, n)](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_50.java)
2. [367 有效的完全平方数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_367.java)
3. [744 寻找比目标字母大的最小字母](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_744.ja)

### 更多练习1

1.
2. [154 寻找旋转排序数组中的最小值 II](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_154.java)
3. [349 两个数组的交集](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_349.java)
4. [350 两个数组的交集II](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_350.java)

### 更多练习2

1. [287 寻找重复数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_287.java)
2. [4 寻找两个有序数组的中位数](https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/_4.java)