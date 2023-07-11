package Day11072023;


// valid Sodoku

import java.util.HashMap;
import java.util.HashSet;

public class Question4 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                    ,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        boolean ans  = validSoduku(board);
        System.out.println(ans);
    }

    private static boolean validSoduku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.' && (!set.add(board[i][j]+"in row "+i) || !set.add(board[i][j]+"in col "+j) || !set.add(board[i][j]+"Found in sub mat "+i/3+"and"+j/3))){
                    return false;
                }
            }
        }
        return true;
    }
}
