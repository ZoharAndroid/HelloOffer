package Java.code;

public class StaticExample {

    private static int x;
    private int y;

    public static void func1(){
        int a = x;
        // int b = y;  静态方法中的变量只能被静态成员变量赋值
    }
}
