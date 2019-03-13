package offer;

public class Problem17 {

    private void print1ToMaxOfNDigits(int n){
        if ( n <= 0){
            return ;
        }

        char[] numbers = new char[n];
        print1ToMaxOfNDigits(numbers,0);


    }

    private void print1ToMaxOfNDigits(char[] numbers, int digits){
        if (digits == numbers.length){
            printNumber(numbers);
            return;
        }

        for (int i = 0; i < 10; i++){
            numbers[digits] = (char)('0' + i);
            print1ToMaxOfNDigits(numbers, digits + 1);
        }
    }


    private void printNumber(char[] numbers){
        // 消除前面为0的位
        int index = 0;
        while (index < numbers.length && numbers[index] == '0'){
            index++;
        }

        while (index < numbers.length){
            System.out.print(numbers[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Problem17 p = new Problem17();
        p.print1ToMaxOfNDigits(100);
    }
}
