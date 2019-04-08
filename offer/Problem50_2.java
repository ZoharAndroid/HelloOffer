package offer;


/**
 * 面试题50_2：字符流中第一个只出现一次的字符
 *
 */
public class Problem50_2 {

    private int[] occurrence;
    private int index;

    public Problem50_2(){
        occurrence = new int[256];
        for (int i = 0; i < occurrence.length; i++){
            occurrence[i] = -1; // 初始默认为-1
        }

    }

    private void Insert(char ch){
        if (occurrence[ch] == -1){
            occurrence[ch] = index; // 如果为-1，说明该字符以前还没有出现过，所以，用数组来记录下该字符在字符串中出现的位置
        }else if (occurrence[ch] >= 0 ){
            // 如果为>=0 的，说明该字符在之前出现过，那么就可以重新赋值，直接忽略掉
            occurrence[ch] = -2; // 这里设置成-2，来标志该字符可以直接忽略掉了
        }

        index++; // 每次插入一下，索引index就需要增加1
    }


    public char fristAppearingOnce(){
        char ch = ' ';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++){
            if (occurrence[i] >= 0 && occurrence[i] < minIndex){
                minIndex = occurrence[i]; // 重新赋值最小值
                ch = (char)i; // 记录该字符
            }
        }

        return ch;
    }



}
