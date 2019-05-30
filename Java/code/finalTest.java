package Java.code;

public class finalTest {

    private static void foo(final int args){
        final int val = 0;
        System.out.println(val + " " + args);
    }

    private static void foo1(int args){
        int val = 0;
        System.out.println(val + " " + args);
    }


    public static void main(String[] args){
        foo(10);

    }
}
