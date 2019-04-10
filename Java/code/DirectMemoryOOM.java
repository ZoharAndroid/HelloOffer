package Java.code;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeField.get(null);
        }catch (Throwable e){
            e.printStackTrace();
        }
        while (true){
            unsafe.allocateMemory(_1MB);
        }

    }
}
