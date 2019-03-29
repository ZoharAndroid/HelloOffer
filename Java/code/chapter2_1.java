package Java.code;

public class chapter2_1 {

    public static void main(String[] args){
        String a = new String("abc");
        String b = new String("abc");
        System.out.println( a == b); // false

        String x = a.intern();
        String y = a.intern();
        System.out.println( x == y); // true
        System.out.println( x + "  " + y);// abc  abc

        String m = "aaa";
        String n = "aaa";
        System.out.println(m == n); // true
    }
}
