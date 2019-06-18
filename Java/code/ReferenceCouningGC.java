package Java.code;

public class ReferenceCouningGC {

    public Object instance = null;

    public static void main(String[] args){
        ReferenceCouningGC objA = new ReferenceCouningGC();
        ReferenceCouningGC objB = new ReferenceCouningGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
