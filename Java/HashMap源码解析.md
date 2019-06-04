
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

一些相关问题：

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

## put方法
```java
//将指定的值与此映射中的指定键相关联。 如果映射先前包含键的映射，则替换旧值。
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // table未初始化或者长度为0，进行扩容
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        // (n - 1) & hash 确定元素存放在哪个桶中，桶为空，新生成结点放入桶中(此时，这个结点是放在数组中)
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        // 桶中已经存在元素
        else {
            Node<K,V> e; K k;
             // 比较桶中第一个元素(数组中的结点)的hash值相等，key相等
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                // 将第一个元素赋值给e，用e来记录
                e = p;
             // hash值不相等，即key不相等；为红黑树结点
            else if (p instanceof TreeNode)
                // 放入树中
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            // 为链表结点
            else {
                 // 在链表最末插入结点
                for (int binCount = 0; ; ++binCount) {
                    // 到达链表的尾部
                    if ((e = p.next) == null) {
                        // 在尾部插入新结点
                        p.next = newNode(hash, key, value, null);
                        // 结点数量达到阈值，转化为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                     // 判断链表中结点的key值与插入的元素的key值是否相等
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        // 相等，跳出循环
                        break;
                    // 用于遍历桶中的链表，与前面的e = p.next组合，可以遍历链表
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```