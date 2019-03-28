package Java.code;

public class chapter1_2 {

    public static void main(String[] args){
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println( x == y); // false

        Integer z = Integer.valueOf(123);
        Integer w = Integer.valueOf(123);
        System.out.println( z == w); // true

        Integer m = 127;
        Integer n = 127;
        System.out.println(m == n); // true

        Integer a = 128;
        Integer b = 128;
        System.out.println( a == b); // false
    }
}
