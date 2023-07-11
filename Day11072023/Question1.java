package Day11072023;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "PROGRAM";
        if(str.length()%2==0) {
            System.out.println("Not Possible !");
          
        }
        else {
            patternPrinting(str);
        }
    }

    private static void patternPrinting(String str) {
        int start = 0;
        int end = str.length()-1;
        int spaces = str.length()-2;
        for (int i = 0; i < (str.length()/2)+1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.print(str.charAt(start)+" ");
            for (int j = 0; j < spaces; j++) {
                System.out.print("  ");
            }
            if(start!=end) {
                System.out.print(str.charAt(end)+" ");
            }
            start++;
            end--;
            spaces-=2;
            System.out.println();
        }

        spaces+=4;
        for (int i = (str.length()/2)+1; i <str.length() ; i++) {
            for (int j = 0; j < str.length()-i-1; j++) {
                System.out.print("  ");
            }
            System.out.print(str.charAt(end)+" ");
            for (int j = 0; j < spaces; j++) {
                System.out.print("  ");
            }
            System.out.print(str.charAt(start));
            start++;
            end--;
            spaces+=2;
            System.out.println();
        }
    }
}
