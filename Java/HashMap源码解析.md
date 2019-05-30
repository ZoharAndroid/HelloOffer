
# HashMap源码解析

[toc]

# HashMap初识

HashMap是键值对的形式存储数据的。实现的是Map接口。

JDK1.8之前，HashMap由**数组+链表**的形式组成的，链表的存在就是为了解决哈希冲突，也就是“拉链法”解决冲突。

JDK1.8之后，当链表长度大于阈值（默认为8）时，将链表转换为红黑树，减少搜索时间。

# HashMap源码分解

## 构造方法

```java
    //使用指定的初始容量和加载因子构造一个空的HashMap 
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY) // 最大容量为1<<30
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) //isNaN方法是判断一个数是否是数值
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    // 使用指定的初始容量和默认加载因子（0.75）构造一个空的HashMap
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // 使用默认的容量大小(16) 和默认的加载因子 (0.75).
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    /**
     * 构造一个新的HashMap，其映射与指定的Map相同。HashMap是使用默认加载因子（0.75）创建的。
     */
    public HashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }
```

1. 为什么最大容量为1<<30?
   int类型为4字节，32位，而Java有个符号位，所以最大只能是31位，只能向左移动30位。

2. tableSizeFor方法实现：
```java
    //为给定的目标容量提供两个大小的幂。
     static final int tableSizeFor(int cap) {
         int n = cap - 1;
         n |= n >>> 1;
         n |= n >>> 2;
         n |= n >>> 4;
         n |= n >>> 8;
         n |= n >>> 16;
         return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
         }
```

3. putMapEntries()方法
```java
//实现Map.putAll和Map构造函数
final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
    int s = m.size();
    if (s > 0) {
        if (table == null) { // pre-size
            float ft = ((float)s / loadFactor) + 1.0F;
            int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
            if (t > threshold)
                threshold = tableSizeFor(t);
        }else if (s > threshold)
            resize();
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            putVal(hash(key), key, value, false, evict);
        }
    }
}
```