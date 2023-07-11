package Day11072023;

import java.util.Scanner;

public class Question3 {
    static boolean found  =false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "WELCOMETOZOHOCORPORATION";
        int row =(int) Math.ceil((double)str.length()/5);
        char[][] matrix = new char[row][5];
        int index  = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(index==str.length())break;
                matrix[i][j] = str.charAt(index);
                index++;
            }
        }
        int[] ans = new int[4];
        String sub = "MORP";
        int[] rowArray  = {0,1,0,-1};
        int[] colArray = {1,0,-1,0};
        boolean [][] visted = new boolean[row][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(found)break;
                if(matrix[i][j] == sub.charAt(0) && !visted[i][j]) {
                    ans[0] = i;
                    ans[1] = j;
                    findSubstringInMatrix(matrix, ans, sub, rowArray, colArray, visted, i, j,1);

                }
            }
        }
            System.out.println("Start Index : "+ans[0]+","+ans[1]);
        System.out.println("End Index : "+ans[2]+","+ans[3]);

    }

    private static void findSubstringInMatrix(char[][] matrix, int[] ans, String sub, int[] rowArray, int[] colArray , boolean[][] visted, int row, int col, int index) {
        if( index == sub.length()){
            found = true;
            ans[2] = row;
            ans[3] = col;
            return;
        }
        visted[row][col] = true;
        if(!found){
            for (int i = 0; i < rowArray.length; i++) {
                int nbrRow = row + rowArray[i];
                int nbrCol = col+ colArray[i];

                if(nbrRow>=0 && nbrRow<matrix.length && nbrCol>=0 && nbrCol<matrix[0].length && !visted[nbrRow][nbrCol] && matrix[nbrRow][nbrCol] == sub.charAt(index)){
                    findSubstringInMatrix(matrix, ans, sub, rowArray, colArray, visted, nbrRow, nbrCol, index+1);
                }
            }
        }
        visted[row][col] =false;

    }

}
