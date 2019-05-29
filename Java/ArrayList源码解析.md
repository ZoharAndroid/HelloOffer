# ArrayList源码解析

- [ArrayList源码解析](#arraylist%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90)
  - [ArrayList源代码](#arraylist%E6%BA%90%E4%BB%A3%E7%A0%81)
  - [ArrayList源码中的System.arraycopy()和Arrays.copyOf()](#arraylist%E6%BA%90%E7%A0%81%E4%B8%AD%E7%9A%84systemarraycopy%E5%92%8Carrayscopyof)
  - [ArrayList的扩容机制](#arraylist%E7%9A%84%E6%89%A9%E5%AE%B9%E6%9C%BA%E5%88%B6)

## ArrayList源代码

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
    // 1. ArrayList继承了AbstractList抽象类，实现了List，提供了List的一些添加、删除、
    //  修改、遍历等基本的功能。
    // 2. ArrayList实现了RandomAccess接口，表明ArrayList是支持快速随机访问的，我们
    //  可以通过元素的索引直接访问元素。
    // 3. ArrayList实现了Cloneable接口，说明可以进行复制。
    // 4. ArrayList实现了Serializable接口，说明可以进行序列化。
{
    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * 默认初始容量大小是10.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空的实例数组.当用户指定使用容量大小的构造方法的时候，
     * 元素数组与空元素数组共享。
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 默认大小的空实例数组。与EMPTY_ELEMENTDATA区别开。
     * 这个是用户调用没有指定容量大小的构造方法时，
     * 元素数组与默认大小空元素数组共享一块地址。
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存储元素的数组
     * 这是用transient进行修饰的，不参与序列化过程。
     */
    // Android-note: Also accessed from java.util.Collections
    transient Object[] elementData; // non-private to simplify nested class access

    // 元素的个数
    private int size;

    /**
    *   带初始容量的构造方法
    */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            // 如果初始容量大于0，则按照用户指定的容量大小创建对象数组
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            // 如果初始容量等于0，将元素对象数组指向空对象数组
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            // 如果是其他大小，则抛出异常
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }

    /**
     * 无参构造方法
     */
    public ArrayList() {
        // 将元素数组指向默认大小容量的空对象数组
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 按照集合的迭代器返回的顺序构造一个包含指定集合元素的列表。
     */
    public ArrayList(Collection<? extends E> c) {
        // 通过调用toArray()方法转换成数组
        elementData = c.toArray();
        // 如果有元素存在
        if ((size = elementData.length) != 0) {
            // c.toArray可能不会或者不正确返回Object[]数组，所以下面加了一条判断语句
            if (elementData.getClass() != Object[].class)
                // 如果不是Object[]，那面直接通过Arrays.copyOf()方法进行复制，也就是将。
                // 类型转换成Object[].
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // c集合中没有元素存在，那么就直接指向空对象数组。
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 将此ArrayList实例的容量调整为列表的当前大小。
     * 应用程序可以使用此操作来最小化ArrayList实例的存储。
     */
    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            // 如果当前size的大小与对象数组保存的元素大小不一致
            elementData = (size == 0)   // 判断size是否为0，
              ? EMPTY_ELEMENTDATA // 如果为0，那么将元素数组指向空对象数组
              : Arrays.copyOf(elementData, size); // 如果size不为0，说明有元素存在，
                                                  // 那么元素数组就指向size大小的新的元素数组
        }
    }

    /**
     * 增加ArrayList实例的容量，以确保它至少可以容纳由minimum capacity参数指定的元素数。
     */
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
        // 判断元素数组是否使用的默认容量大小的元素数组
            // any size if not default element table
            ? 0 // 如果不是使用的默认容量大小的数组，那么minExpand = 0；
            : DEFAULT_CAPACITY;  // 如果使用的是默认容量大小的元素数据，那么minExpand = 10;

        if (minCapacity > minExpand) {
            // 确定是否需要进行扩容操作
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 如果元素对象数组为默认容量大小的元素数组
            // 比较默认大小10，和需要扩容大小进行比较
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
        // 调用grow()方法，进行扩容操作
            grow(minCapacity);
    }

    // 最大可分配数组大小
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 扩容主要方法
     * 增加容量，以确保它至少可以容纳由minimum capacity参数指定的元素数。
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;  // 原来设定的容量
        // 新容量大小设定为原来容量大小的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新设定的容量比最小需要容量还小，那么就把新容量设定为最小需要容量
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 如果新设定的容量超过了最大数组容量，
        // 就需要通过hugeCapacity()来调整新设定的容量。
        // hugeCapacity()方法是比较minCapacity和MAX_ARRAY_SIZE的大小。
        // 如果minCapacity为负数，抛出OOM异常；如果minCapacity大于
        // MAX_ARRAY_SIZE则将新容量大小设置为Integer.MAX_VALUE，
        // minCapacity小于MAX_ARRAY_SIZE则设定为MAX_ARRAY_SIZE。
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        // 将元素数组复制到新设定的容量上
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }

    // 返回list中的个数
    public int size() {
        return size;
    }

   // 判断list中是否为空，也就是通过size是否为0来判断
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回list中是否包含o对象
    public boolean contains(Object o) {
        // 调用indexOf()方法，查看list中首次出现o对象的索引，如果没有
        // 那么indexOf方法就会返回-1，所以也就会返回false，如果list中
        // 包含了o对象，那么就返回true
        return indexOf(o) >= 0;
    }

    // 返回list中指定对象第一次出现的索引。
    public int indexOf(Object o) {
        if (o == null) {
            // 如果要查询的对象为null，遍历元素对象数组
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            // 要查询的对象不是null，用equals方法判断对象是否相同。
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        // 没有查询到，那么返回-1
        return -1;
    }

    // List中最后一次出现的索引位置，如果没有，则返回-1。
    // 基本思想就是从后往前进行遍历
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 返回此ArrayList实例的浅拷贝。（元素本身不会被复制。）
     */
    public Object clone() {
        try {
            ArrayList<?> v = (ArrayList<?>) super.clone();
            // 通过Arrays.copyOf方法复制size个元素对象数组到v元素数组中
            v.elementData = Arrays.copyOf(elementData, size);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     *以适当的顺序（从第一个元素到最后一个元素）返回包含此列表中所有元素的数
     *组。
     *   
     *返回的数组将是“安全的”，因为此列表不会保留对它的引用。 （换句话说，此方
     *法必须分配一个新数组）。 因此调用者可以自由修改返回的数组。
     *
     *此方法充当基于数组和基于集合的API之间的桥梁。
     *
     *@return一个数组，按正确顺序包含此列表中的所有元素
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 以正确的顺序返回一个包含此列表中所有元素的数组（从第一个到最后一个元素）; 
     *返回的数组的运行时类型是指定数组的运行时类型。 如果列表适合指定的数组，则返回其中。 
     *否则，将为指定数组的运行时类型和此列表的大小分配一个新数组。 
     *如果列表适用于指定的数组，其余空间（即数组的列表数量多于此元素），则紧跟在集合结束后的数组中的元素设置为null 。
     *（这仅在调用者知道列表不包含任何空元素的情况下才能确定列表的长度。）
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // 创建一个新的运行时数组，内容是ArrayList的内容
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        // 调用系统的arrayCopy方法复制数组
        System.arraycopy(elementData, 0, a, 0, size);
        // 数组元素多于ArraryList中的元素，你妈在size后面设置为null
        if (a.length > size)
            a[size] = null;
        return a;
    }

    // 返回指定索引位置的元素对象，如果索引超过ArrayList中元素的个数，那么抛出IndexOutOfBoundsException
    public E get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        return (E) elementData[index];
    }

    // 指定索引位置替换成新的元素对象，并返回原来索引位置的元素对象
    public E set(int index, E element) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    // 在数组末尾添加元素对象
    public boolean add(E e) {
        // 每增加1次，当数组元素大于默认值的时候，就会调用grow方法进行扩容操作
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    // 指定索引位置添加指定元素对象
    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        // 确保容量大小能够储存指定对象，否则进行扩容操作
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        // 调用System.arraycopy方法将index之后的元素向后移动1位
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
        elementData[index] = element;
        size++;
    }

    // 删除指定索引位置的元素，并返回删除的元素。
    public E remove(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        modCount++;
        E oldValue = (E) elementData[index];
        // 需要向左移动元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            // 从index+1的位置开始复制numMove个数元素到index位置
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        // 最后一个元素设置成null，好让GC进行回收
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    // 删除指定元素对象，如果有，则删除第一次出现的元素对象，如果没有，则ListArray不会变化。
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    /*
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    // 删除所有的元素
    public void clear() {
        modCount++;

        // clear to let GC do its work
        // 把元素对象数中的所有值都设置成null，好让GC进行回收
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    // 将指定集合中的所有元素追加到此列表的末尾
    public boolean addAll(Collection<? extends E> c) {
        // 将集合转换成对象数组
        Object[] a = c.toArray();
        int numNew = a.length;
        // 进行扩容操作
        ensureCapacityInternal(size + numNew);  // Increments modCount
        // 将a对象数组复制到elementData对象数组的末尾
        System.arraycopy(a, 0, elementData, size, numNew);
        // 修改Size的大小
        size += numNew;
        return numNew != 0;
    }

    /**
     *从指定位置开始，将指定集合中的所有元素插入此列表。
     *将当前位于该位置的元素（如果有）和任何后续元素移位到右侧（增加其索引）。
     *新元素将按照指定集合的​​迭代器返回的顺序在列表中显示。
     *
     * 注意是从指定的index位置开始，包括index都要往后移动
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0)
            // 将elementData中的对象元素从index开始复制到index+nunNew开始
            // 相当于偏移numNew个位置
            System.arraycopy(elementData, index, elementData, index + numNew,
                             numMoved);
        // 然后将a对象数组复制到elementData的index处
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    // 从此列表中删除fromIndex（包含）和 toIndex之间的所有元素（不包括在内）。
    protected void removeRange(int fromIndex, int toIndex) {
        // Android-changed: Throw an IOOBE if toIndex < fromIndex as documented.
        // All the other cases (negative indices, or indices greater than the size
        // will be thrown by System#arrayCopy.
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }

        modCount++;
        int numMoved = size - toIndex;
        // 移动元素从toIndex开始复制到fromIndex的位置
        System.arraycopy(elementData, toIndex, elementData, fromIndex,
                         numMoved);

        // clear to let GC do its work
        int newSize = size - (toIndex-fromIndex);
        // 将后面的对象数组的值设置成为null
        for (int i = newSize; i < size; i++) {
            elementData[i] = null;
        }
        size = newSize;
    }

    /**
     * 输出相关信息
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    // 删除集合中的指定的所有元素
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    // 仅保留此列表中包含在指定集合中的元素。换句话说，从该列表中删除未包含在指定集合中的所有元素。
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    // 利用了r和w双指针操作来处理。
    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(elementData, r,
                                 elementData, w,
                                 size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    } 

    //从列表中的指定位置开始，返回此列表中元素的列表迭代器
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: "+index);
        return new ListItr(index);
    }

    //返回此列表中元素的列表迭代器（正确序列）。
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    //以适当的顺序返回此列表中元素的迭代器。
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * 返回指定的 fromIndex（包含）和toIndex之间的此列表部分的视图。
     *（如果fromIndex和toIndex相等，则返回的列表为 empty。）
     */
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        // 具体SubList代码不继续作分析了，查阅通过IDEA去查看源码
        return new SubList(this, 0, fromIndex, toIndex); 
    }
    // 返回边界检查
    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                               ") > toIndex(" + toIndex + ")");
    }
}
```
## ArrayList源码中的System.arraycopy()和Arrays.copyOf()

ArrayList源代码中大量使用了这两个数组复制的方法。比如:**toArray**()方法
```java
public Object[] toArray() {
    return Arrays.copyOf(elementData, size);
}
```

两者的联系和区别：

1. System.arraycopy()方法代码：

```java
public static native void arraycopy(Object src, int  srcPos, Object dest, int destPos, int length);
```
[todo]添加arraycopy的源代码

2. Arrays.copyOf()方法代码：


```java
public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
    T[] copy = ((Object)newType == (Object)Object[].class)
    ? (T[]) new Object[newLength] 
    : (T[]) Array.newInstance(newType.getComponentType(), newLength);
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
    return copy;
}

 public static <T> T[] copyOf(T[] original, int newLength) {         
     return (T[]) copyOf(original, newLength, original.getClass());    
 }
```

> 1. 可以看Arrays.copyOf()方法中也调用了System.arraycopy()方法；
> 2. Arrays.copyOf()是新建了一个copy数组，然后返回该数组；System.arraycopy()方法需要目标数组，将原数组拷贝到你自己定义的数组里，而且可以选择拷贝的起点和长度以及放入新数组中的位置；

## ArrayList的扩容机制

ArrayList的扩容机制是ArrayList中源代码中需要着重了解的部分。主要是grow()方法。