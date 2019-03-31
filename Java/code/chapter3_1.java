package Java.code;

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
       // System.out.println(dog.getObjectAddress());//@73035e27
        fun(dog);
       // System.out.println(dog.getObjectAddress());//@73035e27
        System.out.println(dog.getName());// A

        float f = 1.1f;
        short s1 = 1;
        s1 = (short)(s1 + 1);

//        long x = 111l;
//        switch (x){ // Incompatible types. Found: 'long', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
//            case 111:
//                break;
//            case 222:
//                break;
//        }


    }

    private static void fun(Dog dog){
        dog.setName("B");

        //System.out.println(dog.getObjectAddress());//@73035e27
       // dog = new Dog("B");
       // System.out.println(dog.getObjectAddress());//@64c64813
       // System.out.println(dog.getName());// B
    }
}
