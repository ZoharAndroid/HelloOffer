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

---

1. [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Java%20%E5%9F%BA%E7%A1%80.md)