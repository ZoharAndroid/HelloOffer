public class Problem04 {

    /**
     * 面试题4：二维数组中的查找
     *
     * @param matrix
     * @param number
     * @return
     */
    private boolean find(int[][] matrix,int number){
        boolean found = false;

        if (matrix != null) {
            int rows = matrix.length;
            int columns = matrix[0].length;

            int row = 0;
            int column = columns - 1; // 选取一个值为右上角

            while (row < rows && column >= 0){
                if (matrix[row][column] == number){
                    found = true;
                    break;
                }else if (matrix[row][column] > number){
                    // 选取的值大于要目标值，这删除当前列
                    column--;
                }else{
                    // 选取的值小于目标值，则删除当前行
                    row++;
                }
            }

        }

        return found;
    }

    public static void main(String[] args){
        Problem04 p = new Problem04();
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(p.find(matrix,7));// 查找的数在数组中 -> true
        System.out.println(p.find(matrix,5));// 查找的数不在数组同 -> false
        System.out.println(p.find(matrix,1));// 查找的数为最小的 -> true
        System.out.println(p.find(matrix,15));// 查找的数为最大的 -> true
        System.out.println(p.find(matrix,0));// 查找的数为最小的还小 -> false
        System.out.println(p.find(matrix,16));// 查找的数为最小的还打 —> false
        System.out.println(p.find(null,1));// 空处理 -> false

    }

}
