package Java.code;

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        ++stackLength;
        stackLeak();
    }

    public static void main(String[] args){
//        JavaVMStackSOF oom = new JavaVMStackSOF();
//        try{
//            oom.stackLeak();
//        }catch (Throwable throwable){
//            System.out.println(oom.stackLength);
//            throw throwable;
//        }

        String str2 = new StringBuilder("jav").append("a").toString();
        System.out.println(str2.intern() == str2);

        String str1= new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);




    }
}
