[TOC]

# 1. 数据类型

## 1.1 基本类型

* byte：8
* char：16
* short：16
* int：32
* float：32
* long：64
* double：64
* boolean：JVM没有明确规定大小。JVM在编译期间将boolean类型数据转换成int类型，1代表true，0表示false。

## 1.2 缓存池

`new Integer(123)` 和 `Integer.valueOf(123)` 的区别？

* new Integer(123)每次都会创建一个新的对象；
* Integer.valueOf(123)会调用缓存池中的对象，多次调用会取得同一个对象的引用。
  
```
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println( x == y); // false

        Integer z = Integer.valueOf(123);
        Integer w = Integer.valueOf(123);
        System.out.println( z == w); // true
```

valueOf()方法首先会判断i是否在缓存池中，如果在的话就会直接返回缓存池中的内容，如果没有，就会用new Integer（）创建一个新的对象。
```
public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
        // 判断是否在缓存池范围中，如果在，则返回缓存池中的内容
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
```

看下IntegerCache的代码
```
private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            // 这一段可以不用仔细去了解，大概意思应该是可以通过配置文件来调整high的值。
            int h = 127; // 默认high的值为127
            String integerCacheHighPropValue =
                VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127); // 判断设置的值与127默认值哪个大取哪个
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1]; // 创建缓存数组
            int j = low;// j = -128
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);// 在数组[0,high + (-low)]中对应填入-128，-127，......,0,1,.....high个值。

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }
```

> 通过上面的源码分析，可以知道默认的Integer缓存池的大小范围是-128~127。也是是说在这个范围里面，只要缓存池中有需要的值，会直接从缓存池中来获取，而不是重新new一个对象。

测试代码：

```
        Integer m = 127;// 编辑器会在自动装箱过程调用ValueOf方法
        Integer n = 127;
        System.out.println(m == n); // true

        Integer a = 128;
        Integer b = 128;
        System.out.println( a == b); // false
```

# 2 String

## 2.1 String类的源码
```
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
        // The value is used for character storage，用字节数组进行存储
        private final byte[] value;
        // 编码
        private final byte coder;
    }
```
> 1. String内部用字节数组来存储字符串，使用coder来标识编码
> 2. String类被final声明，说明String类不可以被继承
> 3. value[]数组被final声明，说明value []数组被初始化之后，不可以改变。

## 2.2 String/StringBuilder/StringBuffer

### 2.2.1 StringBuilder/StringBuffer的源码

StringBuilder源码：
```
public final class StringBuilder
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence {  
    public StringBuilder() {
        super(16);
    }
}
```

StringBuffer源码：
```
public final class StringBuffer
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence{
        public StringBuffer() {
        super(16);
    }
}
```
> 可以看到StringBuffer和StringBuilder都是继承了AbstractStringBuilder这个抽象类，下面看下这个AbstractStringBuilder主要是什么内容。

AbstractStringBuilder源码：
```
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    /**
     * The value is used for character storage.
     */
    byte[] value;

    /**
     * The id of the encoding used to encode the bytes in {@code value}.
     */
    byte coder;
```
> 这里也定义了字节数组和coder编码方式。但是没有用final声明。

### 2.2.2 比较

1. 可变性
   * String有final修饰，说明不可变
   * StringBuffer和StringBuilder，是可变的
  
2. 线程安全
   * String不可变，说明线程安全
   * StringBuilder，线程不安全
   * StringBuffer，线程安全，源码可以看出（方法都用synchronized来声明，比如charAt()方法：`public synchronized char charAt(int index) {
        return super.charAt(index);
    }`)


### 2.3 String Pool

String Pool保存着所有字符串的字面量。下面看个例子：
```
public static void main(String[] args){
        String a = new String("abc");
        String b = new String("abc");
        System.out.println( a == b); // false

        String x = a.intern();
        String y = a.intern();
        System.out.println( x == y); // true
        System.out.println( x + "  " + y);// abc  abc
    }
```
> a 和 b 用new创建一个字符串对象，如果直接用两个对象进行比较，肯定是不相等的，地址不一样。而调用了`intern()`方法后，x==y说明这两个字符串对象指向的是同一个地址，也就是说明了，intern()方法首先把 a 引用的字符串放到 String Pool 中，然后返回这个字符串引用。因此 x 和 y 引用的是同一个字符串。

看下`intern()`方法的源码:
```
/**
     * Returns a canonical representation for the string object.
     * <p>
     * A pool of strings, initially empty, is maintained privately by the
     * class {@code String}.
     * <p>
     * When the intern method is invoked, if the pool already contains a
     * string equal to this {@code String} object as determined by
     * the {@link #equals(Object)} method, then the string from the pool is
     * returned. Otherwise, this {@code String} object is added to the
     * pool and a reference to this {@code String} object is returned.
     * <p>
     * It follows that for any two strings {@code s} and {@code t},
     * {@code s.intern() == t.intern()} is {@code true}
     * if and only if {@code s.equals(t)} is {@code true}.
     * <p>
     * All literal strings and string-valued constant expressions are
     * interned. String literals are defined in section 3.10.5 of the
     * <cite>The Java&trade; Language Specification</cite>.
     *
     * @return  a string that has the same contents as this string, but is
     *          guaranteed to be from a pool of unique strings.
     * @jls 3.10.5 String Literals
     */
    public native String intern();
```
> 这代码的解释也说明了，当String Pool中包含了字符串的值，那么就直接返回该值，如果没有，这个字符串就会添加到String Pool中然后再返回这个值。


如果直接采用字符串直接赋值的方式，就会自动将字符串放入String Pool中
```
        String m = "aaa";
        String n = "aaa";
        System.out.println(m == n); // true
```

## 2.4 new String("abc")方法：
源代码：
```
public String(String original) {
        this.value = original.value;
        this.coder = original.coder;
        this.hash = original.hash;
    }
```
> `new String("abc")`并不是直接赋值一个字符串，而是将value变量指向原来的(original)value数组。

# 3 运算相关问题

## 3.1 参数传递

Java方法中参数的传递是**值传递**，而不是引用传递。

下面看个例子来说明是值传递。
```
public class chapter3_1 {

    static class Dog {
        private String name;

        public Dog(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 返回当前对象地址
         *
         * @return
         */
        public String getObjectAddress(){
            return this.toString();
        }
    }

    public static void main(String[] args){
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());//@73035e27
        fun(dog);
        System.out.println(dog.getObjectAddress());//@73035e27
        System.out.println(dog.getName());// A
    }

    private static void fun(Dog dog){
        System.out.println(dog.getObjectAddress());//@73035e27
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());//@64c64813
        System.out.println(dog.getName());// B
    }
}
```
> 可见，Dog("A")的对象dog传递给fun方法相当于一个指针变量，所以fun方法中的第一个println打印的地址和main方法中打印的地址是一样的。当fun函数让形参dog重新指向新的对象的时候Dog("B")，第二个println打印就是一个新的地址。在main()函数中虽然经过了fun方法，让dog重新指向新的地址，但是fun方法一结束，新指向的地址变量也就销毁了，main方法中的dog对象在程序后面还在使用，所以并不会销毁，所以还是指向原来的地址。

```
public static void main(String[] args){
        Dog dog = new Dog("A");
        fun(dog);
        System.out.println(dog.getName());// B


    }

    private static void fun(Dog dog){
        dog.setName("B");
    }
```
> 经过上面的分析，也就可以知道fun方法修改dog对象子段在main方法中为什么输出的是B啦。因为改变的是同一个地址指向的内容。

## 3.2 float与double

Java不能隐士向下转型，因为会降低精度。

```
float f = 1.1;
```
![](https://github.com/ZoharAndroid/MarkdownImages/blob/master/2019-3-31/float%20and%20doble.png?raw=true)
> 这里会报错，1.1属于doble类型，是不能直接从double赋值给float，因为是向下转型。
> 如果要解决的话，就需要显示定义`float f = 1.1f;`

## 3.3 隐士类型转换

```
short s1 = 1;
// s1 = s1 + 1; 这里会进行报错，因为s1 + 1 是int类型 而s1是short类型，所以不能向下转型。
```
> 如果要处理必须修改为`s1 = (short) (s1+1);`

## 3.4 switch

switch是不支持long类型的比较的。
```
 long x = 111;
        switch (x){ // Incompatible types. Found: 'long', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
            case 111:
                break;
            case 222:
                break;
        }
```
> 这里会提示，switch是无法比较long类型的变量的。

---
参考资料：

1. [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Java%20%E5%9F%BA%E7%A1%80.md)