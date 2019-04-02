package Java.code;

public class chapter4_1 {

    static class Person{
        // private String name;
        private String type;

        public void say(){
            System.out.println("Person");
        }

        public void eat(){
            System.out.println("Person eat...");
        }
    }

    static class Chinese extends Person{
        @Override
        public void say() {
            //super.say();
            System.out.println("Chinese");
        }

        public void write(){
            System.out.println("Chinese write");
        }
    }

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

        Person p = new Chinese();
        p.say();// Chinese
        p.eat();// Person eat...

    }
}
