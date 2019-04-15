package algorithm.数组和字符串;

public class TwoOriginal {

    public static void main(String[] args){
        int[][] a = new int[2][5];
        printArray(a);
        int[][] b = new int[2][];
        printArray(b); // null null
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }

    private static void printArray(int[][] arrays){
        for (int i = 0; i < arrays.length; i++){
            System.out.println(arrays[i]);
        }

        for (int i = 0; i < arrays.length; i++){
            for (int j = 0; arrays[i] != null && j < arrays[i].length; j++){
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }
}
