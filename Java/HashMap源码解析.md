
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

## 底层数据结构分析

### JDK1.8之前

JDK1.8之前HashMap底层使用的是**数组和链表**的结合，也就是**拉链法**。HashMap通过Key的hashcode经过**扰动函数**处理后得到hash值，然后通过<kbd>(n-1) & hash</kbd>判断当前元素存放的位置（n为数组的长度）。如果当前位置存在元素的话，就判断该元素与要存入的元素的hash值以及key值判断是否相同，如果相同，直接覆盖，不相同就通过拉链法解决冲突。

**扰动函数**就是指HashMap的hash方法。只要是防止一些效果较差的hashcode()方法，减少碰撞。

```java
static final int hash(Object key) {
        int h;
        // key.hashcode：返回hash值
        // >>> ：无符号右移，空位以0补位
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

**拉链法**：将链表和数组结合。数组的每一格对应一个链表。如果遇到哈希冲突，然后将冲突的值加到链表中即可。
![](https://camo.githubusercontent.com/eec1c575aa5ff57906dd9c9130ec7a82e212c96a/68747470733a2f2f757365722d676f6c642d63646e2e786974752e696f2f323031382f332f32302f313632343064626363333033643837323f773d33343826683d34323726663d706e6726733d3130393931)

### JDK1.8之后

主要在解决哈希冲突有了较大的变化，当链表长度大于阈值（默认值为8）时，将链表转化为红黑树，以减少搜索时间。
![](https://camo.githubusercontent.com/20de7e465cac279842851258ec4d1ec1c4d3d7d1/687474703a2f2f6d792d626c6f672d746f2d7573652e6f73732d636e2d6265696a696e672e616c6979756e63732e636f6d2f31382d382d32322f36373233333736342e6a7067)

### 类的属性

```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {
    // 序列号
    private static final long serialVersionUID = 362498820763181265L;
    // 默认初始容量为16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    // 最大容量为2^30
    static final int MAXIMUM_CAPACITY = 1 << 30;
    // 默认的填充因子为0.75f
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 当桶的节点大于8的时候会转换成红黑树
    static final int TREEIFY_THRESHOLD = 8;
    // 当桶上的节点小于这个值的时候会转换成链表
    static final int UNTREEIFY_THRESHOLD = 6;
    // 桶中结构转化为红黑树对应的table的最小容量
    static final int MIN_TREEIFY_CAPACITY = 64;
    // 节点数组，数量总是2的幂次方
    transient Node<K,V>[] table;
    // 存放具体的元素集合
    transient Set<Map.Entry<K,V>> entrySet;
    // 存放元素的个数
    transient int size;
    // 每次扩容和更改map结构的计数器
    transient int modCount;
    // 临界值，当超过临界值（容量*填充因子)时，或进行扩容
    int threshold;
    // 加载因子
    final float loadFactor;
}

```
