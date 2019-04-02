package Java.code;

public class CloneConstructorExample {

    private int[] arr;

    public CloneConstructorExample() {
        // 生成数据集
        arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = i;
        }
    }

    /**
     * 使用构造方法来复制一个新的数组
     *
     * @param original
     */
    public CloneConstructorExample(CloneConstructorExample original){
        arr = new int[original.arr.length];
        for (int i = 0; i < original.arr.length; i++){
            arr[i] = original.arr[i];
        }
    }

    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[] args){
        CloneConstructorExample c1 = new CloneConstructorExample();
        // 复制
        CloneConstructorExample c2 = new CloneConstructorExample(c1);
        // 修改元数组中的内容
        c1.set(2,222);
        //查看复制后的数组
        System.out.println(c1.get(2)); // 222
        System.out.println(c2.get(2)); // 2 没有发生变化，因为是新建的一个数组
    }
}
