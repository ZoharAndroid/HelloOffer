package offer;

public class Problem47 {

    public int getMost(int[][] board) {
        // write code here

        if (board == null || board.length == 0){
            return 0;
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (i == 0 && j == 0){
                    // 这个位置也就是起始点， 不做任何处理
                }else if ( i == 0){
                    // 也就是第一行的位置，那么这行也就只能向右边走了，
                    // 向右走的时候，把后面的值加起来
                    board[i][j] += board[i][j - 1];
                }else if (j == 0){
                    // 也就是处于第一列的位置，那么只能向下走了，
                    // 向下走，那么就把上面的值，加到这个值上面
                    board[i][j] += board[i - 1][j];
                }else{
                    // 如果是其他情况，那么就既可以向前走，又可以向右走，但是要判断哪一个是最大的
                    int tempup = board[i - 1][j];
                    int templeft = board[i][j - 1];
                    if (tempup > templeft){
                        board[i][j] += tempup;
                    }else{
                        board[i][j] += templeft;
                    }
                }
            }
        }

        return board[board.length - 1][board[0].length - 1];
    }
}
