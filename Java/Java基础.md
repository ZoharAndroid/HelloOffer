
- [1. 数据类型](#1-%e6%95%b0%e6%8d%ae%e7%b1%bb%e5%9e%8b)
  - [1.1. 基本类型](#11-%e5%9f%ba%e6%9c%ac%e7%b1%bb%e5%9e%8b)
  - [1.2. 缓存池](#12-%e7%bc%93%e5%ad%98%e6%b1%a0)
- [2. String](#2-string)
  - [2.1. String类的源码](#21-string%e7%b1%bb%e7%9a%84%e6%ba%90%e7%a0%81)
  - [2.2. String/StringBuilder/StringBuffer](#22-stringstringbuilderstringbuffer)
    - [2.2.1. StringBuilder/StringBuffer的源码](#221-stringbuilderstringbuffer%e7%9a%84%e6%ba%90%e7%a0%81)
    - [2.2.2. 比较](#222-%e6%af%94%e8%be%83)
    - [2.2.3. String Pool](#223-string-pool)
  - [2.3. new String("abc")方法](#23-new-string%22abc%22%e6%96%b9%e6%b3%95)
  - [2.4. String a="abc"和String a = new String("abc")](#24-string-a%22abc%22%e5%92%8cstring-a--new-string%22abc%22)
- [3. 运算相关问题](#3-%e8%bf%90%e7%ae%97%e7%9b%b8%e5%85%b3%e9%97%ae%e9%a2%98)
  - [3.1. 参数传递](#31-%e5%8f%82%e6%95%b0%e4%bc%a0%e9%80%92)
  - [3.2. float与double](#32-float%e4%b8%8edouble)
  - [3.3. 隐式类型转换](#33-%e9%9a%90%e5%bc%8f%e7%b1%bb%e5%9e%8b%e8%bd%ac%e6%8d%a2)
  - [3.4. switch](#34-switch)
- [4. 继承](#4-%e7%bb%a7%e6%89%bf)
- [5. Object相关混淆点](#5-object%e7%9b%b8%e5%85%b3%e6%b7%b7%e6%b7%86%e7%82%b9)
  - [5.1. equals方法](#51-equals%e6%96%b9%e6%b3%95)
  - [5.2. clone方法](#52-clone%e6%96%b9%e6%b3%95)
- [6. 构造器Constructor是否可以被override](#6-%e6%9e%84%e9%80%a0%e5%99%a8constructor%e6%98%af%e5%90%a6%e5%8f%af%e4%bb%a5%e8%a2%aboverride)
- [7. 重载和重写的区别](#7-%e9%87%8d%e8%bd%bd%e5%92%8c%e9%87%8d%e5%86%99%e7%9a%84%e5%8c%ba%e5%88%ab)
- [8. 封装、继承和多态](#8-%e5%b0%81%e8%a3%85%e7%bb%a7%e6%89%bf%e5%92%8c%e5%a4%9a%e6%80%81)
- [9. 静态方法内调用一个非静态成员为什么是非法的](#9-%e9%9d%99%e6%80%81%e6%96%b9%e6%b3%95%e5%86%85%e8%b0%83%e7%94%a8%e4%b8%80%e4%b8%aa%e9%9d%9e%e9%9d%99%e6%80%81%e6%88%90%e5%91%98%e4%b8%ba%e4%bb%80%e4%b9%88%e6%98%af%e9%9d%9e%e6%b3%95%e7%9a%84)
- [10. 抽象类和接口的区别](#10-%e6%8a%bd%e8%b1%a1%e7%b1%bb%e5%92%8c%e6%8e%a5%e5%8f%a3%e7%9a%84%e5%8c%ba%e5%88%ab)
- [11. 成员变量和局部变量的区别](#11-%e6%88%90%e5%91%98%e5%8f%98%e9%87%8f%e5%92%8c%e5%b1%80%e9%83%a8%e5%8f%98%e9%87%8f%e7%9a%84%e5%8c%ba%e5%88%ab)
- [12. 对象实体和对象引用](#12-%e5%af%b9%e8%b1%a1%e5%ae%9e%e4%bd%93%e5%92%8c%e5%af%b9%e8%b1%a1%e5%bc%95%e7%94%a8)
- [13. Java中只有值传递，没有引用传递](#13-java%e4%b8%ad%e5%8f%aa%e6%9c%89%e5%80%bc%e4%bc%a0%e9%80%92%e6%b2%a1%e6%9c%89%e5%bc%95%e7%94%a8%e4%bc%a0%e9%80%92)
- [14. 线程、进程和程序的简单概念和联系](#14-%e7%ba%bf%e7%a8%8b%e8%bf%9b%e7%a8%8b%e5%92%8c%e7%a8%8b%e5%ba%8f%e7%9a%84%e7%ae%80%e5%8d%95%e6%a6%82%e5%bf%b5%e5%92%8c%e8%81%94%e7%b3%bb)
- [15. final关键字总结](#15-final%e5%85%b3%e9%94%ae%e5%ad%97%e6%80%bb%e7%bb%93)
- [16. static关键字总结](#16-static%e5%85%b3%e9%94%ae%e5%ad%97%e6%80%bb%e7%bb%93)
- [17. this、super关键字总结](#17-thissuper%e5%85%b3%e9%94%ae%e5%ad%97%e6%80%bb%e7%bb%93)
- [18. 关于自动装箱、拆箱的一个代码思考](#18-%e5%85%b3%e4%ba%8e%e8%87%aa%e5%8a%a8%e8%a3%85%e7%ae%b1%e6%8b%86%e7%ae%b1%e7%9a%84%e4%b8%80%e4%b8%aa%e4%bb%a3%e7%a0%81%e6%80%9d%e8%80%83)
- [19. 手写String中的equals方法](#19-%e6%89%8b%e5%86%99string%e4%b8%ad%e7%9a%84equals%e6%96%b9%e6%b3%95)
- [20. public/protected/private/默认各个访问修饰符的区别](#20-publicprotectedprivate%e9%bb%98%e8%ae%a4%e5%90%84%e4%b8%aa%e8%ae%bf%e9%97%ae%e4%bf%ae%e9%a5%b0%e7%ac%a6%e7%9a%84%e5%8c%ba%e5%88%ab)
- [21. ==、equals和hashCode的区别](#21-equals%e5%92%8chashcode%e7%9a%84%e5%8c%ba%e5%88%ab)
- [22. 谈谈对Java多态的理解](#22-%e8%b0%88%e8%b0%88%e5%af%b9java%e5%a4%9a%e6%80%81%e7%9a%84%e7%90%86%e8%a7%a3)
- [23. 什么是内部类？内部类有什么作用？](#23-%e4%bb%80%e4%b9%88%e6%98%af%e5%86%85%e9%83%a8%e7%b1%bb%e5%86%85%e9%83%a8%e7%b1%bb%e6%9c%89%e4%bb%80%e4%b9%88%e4%bd%9c%e7%94%a8)

# 1. 数据类型

## 1.1. 基本类型

* byte：8
* char：16
* short：16
* int：32
* float：32
* long：64
* double：64
* boolean：JVM没有明确规定大小。JVM在编译期间将boolean类型数据转换成int类型，1代表true，0表示false。

## 1.2. 缓存池

`new Integer(123)` 和 `Integer.valueOf(123)` 的区别？

* new Integer(123)每次都会创建一个新的对象；
* Integer.valueOf(123)会调用缓存池中的对象，多次调用会取得同一个对象的引用。
  
```java
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println( x == y); // false

        Integer z = Integer.valueOf(123);
        Integer w = Integer.valueOf(123);
        System.out.println( z == w); // true
```

valueOf()方法首先会判断i是否在缓存池中，如果在的话就会直接返回缓存池中的内容，如果没有，就会用new Integer（）创建一个新的对象。

```java
public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
        // 判断是否在缓存池范围中，如果在，则返回缓存池中的内容
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
```

看下IntegerCache的代码：

```java
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

```java
        Integer m = 127;// 编辑器会在自动装箱过程调用ValueOf方法
        Integer n = 127;
        System.out.println(m == n); // true

        Integer a = 128;
        Integer b = 128;
        System.out.println( a == b); // false
```

# 2. String

## 2.1. String类的源码

```java
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

## 2.2. String/StringBuilder/StringBuffer

### 2.2.1. StringBuilder/StringBuffer的源码

StringBuilder源码：

```java
public final class StringBuilder
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence {  
    public StringBuilder() {
        super(16);
    }
}
```

StringBuffer源码：

```java
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

```java
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

### 2.2.2. 比较

1. 可变性：
   * `String`源码中的字节数组有final修饰，说明不可变；
   * `StringBuffer`和`StringBuilder`源码中可以看到，都是继承的`AbstractStringBuilder`，而`AbstractStringBuilder`中的字节数组没有final修饰，所以是可变的；
  
2. 线程安全：
   * `String`不可变，说明线程安全；
   * `StringBuilder`，线程不安全；
   * `StringBuffer`，线程安全，源码可以看出（方法都用synchronized来声明，比如charAt()方法：
    ```java
        public synchronized char charAt(int index) {
            return super.charAt(index);
        })
    ```

### 2.2.3. String Pool

String Pool保存着所有字符串的字面量。下面看个例子：

```java
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

```java
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

```java
        String m = "aaa";
        String n = "aaa";
        System.out.println(m == n); // true
```

## 2.3. new String("abc")方法

源代码：

```java
public String(String original) {
        this.value = original.value;
        this.coder = original.coder;
        this.hash = original.hash;
    }
```

> `new String("abc")`并不是直接赋值一个字符串，而是将value变量指向原来的(original)value数组。

## 2.4. String a="abc"和String a = new String("abc")

* String a ="abc"通过赋值得到是一个字符串常量，存在常量池中，如果常量池中原来就有该字符串常量，那么就直接返回，如果没有，那么先存入常量池，然后返回；
* new String("abc")是创建一个String对象，在堆内存中开辟空间进行存储。


# 3. 运算相关问题

## 3.1. 参数传递

Java方法中参数的传递是**值传递**，而不是引用传递。

下面看个例子来说明是值传递。

```java
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

```java
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

## 3.2. float与double

Java不能隐式向下转型，因为会降低精度。

```java
float f = 1.1;
```

![](https://github.com/ZoharAndroid/MarkdownImages/blob/master/2019-3-31/float%20and%20doble.png?raw=true)

> 这里会报错，1.1属于doble类型，是不能直接从double赋值给float，因为是向下转型。
> 如果要解决的话，就需要显示定义`float f = 1.1f;`

## 3.3. 隐式类型转换

```java
short s1 = 1;
// s1 = s1 + 1; 这里会进行报错，因为s1 + 1 是int类型 而s1是short类型，所以不能向下转型。
```

> 如果要处理必须修改为`s1 = (short) (s1+1);`

## 3.4. switch

switch是不支持long类型的比较的。

```java
 long x = 111;
 switch (x){ // Incompatible types. Found: 'long', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
    case 111:
        break;
    case 222:
        break;
}
```

> 这里会提示，switch是无法比较long类型的变量的。

# 4. 继承

一个值得思考的题目

```java
static class A{
    public String show(D obj){
        return "A and D";
    }

    public String show(A obj){
        return "A and A";
    }
}

static class B extends A{
    public String show(B obj){
        return "B and B";
    }

    public String show(A obj){
        return "B and A";
    }
}

static class C extends B{

}

static class D extends B{

}

public static void main(String[] args){
    A a1 = new A();
    A a2 = new B();
    B b = new B();
    C c = new C();
    D d = new D();
    System.out.println(a1.show(b));// A and A
    System.out.println(a1.show(c));// A and A
    System.out.println(a1.show(d));// A and D
    System.out.println(a2.show(b));// B and A，这里需要注意的是要找父类的全部方法和子类共同的方法，就好理解了
    System.out.println(a2.show(c));// B and A，同上面的理解
    System.out.println(a2.show(d));// A and D，同上面的理解
    System.out.println(b.show(b));// B and B
    System.out.println(b.show(c));// B and B
    System.out.println(b.show(d));// A and D
}
```

> 涉及到重写时，方法调用的优先级为：
>  * this.show(O)
>  * super.show(O)
>  * this.show((super)O)
>  * super.show((super)O)
> 参数相同，首先寻找自己本地方法看是否有匹配的，如果没有再寻找父类的相同的方法；
> 参数为父类对象的时候，也是寻找自己类本类的方法，然后在寻找父类中的方法。

这上面的例子中涉及到一个**多态**的概念，A是B的父类，a2就是一个向上转型到父类，这样就是使用父类类型的引用来指向子类对象，**因此这个a2引用就可以调用父类的所有属性和方法，并且只能调用子类中重写父类的方法**。如果a2调用了父类和子类相同名称的方法时候，也就直接调用的是子类重写的方法，而不是父类的那个方法。

# 5. Object相关混淆点

## 5.1. equals方法

先看下equals源码：

```java
public boolean equals(Object obj) {
        return (this == obj);
    }
```

> equals源码就是实现了两个对象实体进行比较。

重写equals方法的步骤（要求）如下：

1. 检查是否为同一个对象的引用，如果是返回true；
2. 检查是否为同一个类型，如果不是返回false；
3. 将Object对象进行转型；
4. 判断每个关键域是否相等；

```java
 class EqualsExample{
        private int x;
        private int y;
        private int z;

        public EqualsExample(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. 判断引用是否相同
            if (this == obj){
                return true;
            }
            // 2. 类型是否相同
            if (obj == null || obj.getClass() != this.getClass()){
                return false;
            }
            // 3. 强转
            EqualsExample that = (EqualsExample)obj;
            // 4. 每个关键域是否相同
            if (this.x != that.x) return  false;
            if (this.y != that.y) return false;
            return this.z == that.z;
        }
    }
```

## 5.2. clone方法

复制方法：在一个构造方法中进行复制内容（深拷贝）

```java
public class CloneConstructorExample {

    private int[] arr;

    public CloneConstructorExample() {
        // 生成数据集
        arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = i;
        }
    }

    /**
     * 使用构造方法来复制一个新的数组
     *
     * @param original
     */
    public CloneConstructorExample(CloneConstructorExample original){
        arr = new int[original.arr.length];
        for (int i = 0; i < original.arr.length; i++){
            arr[i] = original.arr[i];
        }
    }

    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[] args){
        CloneConstructorExample c1 = new CloneConstructorExample();
        // 复制
        CloneConstructorExample c2 = new CloneConstructorExample(c1);
        // 修改元数组中的内容
        c1.set(2,222);
        //查看复制后的数组
        System.out.println(c1.get(2)); // 222
        System.out.println(c2.get(2)); // 2 没有发生变化，因为是新建的一个数组
    }
}
```

浅拷贝：就是复制的和原始的对象都是指向同一个地址，也就是同一个内容的不同引用。
> 其方法就是重新clone方法，然后实现cloneable接口即可。

# 6. 构造器Constructor是否可以被override

父类的私有属性和构造方法是不能被继承的，所以，构造方法是不能被override重写的；但是构造方法是可以进行重载的，可以看到很多类中都重载了构造方法。

# 7. 重载和重写的区别

* 重载：一个类中包含了多个方法名相同，但是**参数个数/参数类型/参数顺序不同**。对于**返回值和访问修饰**可以不相同。
* 重写：发生在父子类中，方法名和参数名、参数类型、参数顺序必须相同，返回值类型小于等于父类，访问修饰符大于等于父类。如果父类的方法访问修饰符为private，那么子类就不能重写该方法。

# 8. 封装、继承和多态

* 封装：是指一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。
* 继承：子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。
**继承注意点：**
    子类拥有父类的所有属性和方法（包括私有属性和方法），但是对于父类的私有属性和方法是无法进行访问的。
* 多态：同一个行为具有多个不同表现形式或形态的能力。

# 9. 静态方法内调用一个非静态成员为什么是非法的

静态方法可以通过类名直接调用，不用再新建对象来调用。因此在静态方法里，不能调用其他非静态变量。

# 10. 抽象类和接口的区别

1. 抽象类可以有构造方法，接口中不能有构造方法。
2. 抽象类中可以有普通成员变量，接口中没有普通成员变量
3. 抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方法。
4. 抽象类中的抽象方法的访问类型可以是public，protected，但接口中的抽象方法只能是public类型的，并且默认即为public abstract类型。
5. 抽象类中可以包含静态方法，接口中不能包含静态方法
6. 抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口中定义的变量只能是public static final类型，并且默认即为public static final类型。
7. 一个类可以实现多个接口，但只能继承一个抽象类。

# 11. 成员变量和局部变量的区别

1. 成员变量属于类，局部变量属于方法或者方法的参数。
2. 成员变量可以被public/private/static等进行修饰，局部变量不能被访问修饰符修饰和static所修饰；但是，成员变量和局部变量都可以用final进行修饰。
3. 成员变量用static进行修饰，则属于类，随着类存在而存在，如果没有用static进行修饰，那么这个成员变量是属于对象的，随着对象的存在而存在。局部变量属于方法，随着方法的调用的结束而结束。
4. 对象存在于堆内存，局部变量存在于栈内存。
5. 成员变量如果没有赋初值，那么会自动以默认的类型赋初值。局部变量则不会。

# 12. 对象实体和对象引用

对象引用就是new出来后的引用名称，比如A a = new A; 那么，A是对象实体，a则是对象引用。对象实体存放在堆内存中，对象引用存放在栈内存中。

# 13. Java中只有值传递，没有引用传递

# 14. 线程、进程和程序的简单概念和联系

* 线程：一个进程可以产生多个线程，线程共享一块内存空间和一组系统资源，所以系统在产生一个线程或者切换各个线程之间系统负担是比进程要小的。
* 进程：简单来说就是运行的程序，是系统运行程序的基本单位。
* 程序：静态代码。包含数据和文件，被存放在磁盘中。

# 15. final关键字总结

1. final关键字使用的地方：类、方法、变量。
2. final使用在类，是防止被继承。final类中的所有方法都被隐式的指定为final方法。
3. final使用在方法，是把方法进行锁定，防止修改方法。
4. final使用在变量，如果变量是基本数据类型，那么一旦进行了初始化，就不能再进行修改了。如果变量是引用类型，那么修改为另外的引用对象。

# 16. static关键字总结

1. **修饰成员变量和方法**：属于类，被类中所有对象共享，通过类名进行调用。静态变量存放在Java内存区的方法区中。
2. **静态代码块**：定义在类中方法外，静态代码块比非静态代码块先执行（静态代码块 -> 非静态代码块 -> 构造方法)。该类不管创造多少对象，静态代码块只执行一次。
3. **静态内部类（static修饰类只能修饰内部类）**：静态内部类与非静态内部类之间存在一个最大的区别: 非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围类，但是静态内部类却没有。没有这个引用就意味着：1. 它的创建是不需要依赖外围类的创建。2. 它不能使用任何外围类的非static成员变量和方法。

static关键字的特点：

1. 在静态方法中是没有this关键字的：
* 静态是随着类的加载而加载，this是随着对象的创建而存在；
* 静态比对象先存在；
2. 静态方法只能访问静态的成员变量和静态的方法，非静态可以访问非静态的也可以访问静态的。
3. 静态变量储存的位置为：方法区

# 17. this、super关键字总结

* this：指的是对象本身。
* super：指的是子类调用的父类对象，也就是父类对象。

# 18. 关于自动装箱、拆箱的一个代码思考

```java
public class Main{
public static void main(String[] args){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        long h = 3L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true , 这里遇到了算术运算会自动进行拆箱
        System.out.println(c.equals(a+b)); // true
        System.out.println(g == ( a + b)); // true
        System.out.println(g.equals(a+b)); // false，equals方法不会进行数据类型转换
        System.out.println(c == h); // true
    }
}
```

> 包装类的"=="运算在不遇到算术运算的情况下，不会自动拆箱;
> equals()方法不处理数据转型

# 19. 手写String中的equals方法

```java
 public boolean equals(Object obj) {
        // 1. 引用是否相同
        if (this == obj) {
            return true;
        }
        // 2. 判断类型是否相同
        if (obj != null && obj instanceof String) {
            // 3. 强制转换
            String anotherString = (String) obj;
            // 4. 判断内部是否相同
            int n = value.length; // value是String源码中保存字符的数组
            if (n == anotherString.value.length) {
                int i = 0;
                char[] v1 = value;
                char[] v2 = antherString.value;
                while (n-- != 0) {
                    if (v1[i] != v2[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

# 20. public/protected/private/默认各个访问修饰符的区别

1. `public`：所有类都可以进行访问；
2. `protected`：同一个包内可以访问，子类可以访问；
3. `默认`：同一个包内可以访问；
4. `private`：本类可以访问，不能继承、不能被重写。

|作用域|当前类|同包|子类|其他|
|:-:|:-:|:-:|:-:|:-:|
|public|            √|         √|       √|      √|
|protected|         √|         √|       √|      ×|
|default|           √|         √|       ×|      ×|
|private|           √|         ×|       ×|      ×|

# 21. ==、equals和hashCode的区别

1. ==：操作符，如果是基本数据类型的比较，那么就是值的比较，如果是引用类型的比较，那么就是比较两个引用的地址是否相等的比较，返回boolean值。
2. equals：Object类的方法，比较两个对象的内容是否相等，返回boolean值。
3. hashCode：Object类的方法，返回对象的hash值，用于确定该对象在哈希表中的索引的位置，是一个int类型的值。

**equals和hashCode的关系**：

1. equals返回true，那么hashCode一定相等。
2. equals不相等，hashCode可能相等。
3. hashCode相等，equals不一定相等。
4. hashCode不相等，equals一定不相等。

# 22. 谈谈对Java多态的理解

多态：就是一个引用在不同情况下的多种状态。通俗来讲，就是父类引用，指向子类对象，调用不同子类中实现的方法。

多态存在的三个必要条件：

1. 要有继承；
2. 要有重写；
3. 父类引用指向子类对象。

# 23. 什么是内部类？内部类有什么作用？

**内部类**：定义在一个类中的类。

**内部类的作用**：

1. 内部类方法可以访问定义外类中的数据，包括private数据。
2. 内部类可以对同一包中的其他类隐藏起来。
3. 内部类可以实现java单继承的缺陷。

**内部类的分类**：

1. 匿名内部类：无构造方法，必须继承一个抽象类或者实现一个接口。
2. 局部内部类：嵌套在方法作用域中。
3. 静态内部类：static修饰的类，不能使用外围类的非static成员变量和方法，不依赖于外围类。
4. 成员内部类：定义在外类内的类。



---
参考资料：

1. [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Java%20%E5%9F%BA%E7%A1%80.md)
2. [JavaGuide](https://github.com/Snailclimb/JavaGuide)
3. [Java基础问题](https://juejin.im/post/5c209718e51d451be35e3e70)