package Day11072023;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i]= sc.nextInt();
        }
        findTheSum(numbers);
    }

    private static void  findTheSum(int[] numbers) {

    HashMap <Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(isPerfectSqaure(numbers[i])){
                map.put(numbers[i],map.getOrDefault(numbers[i],0)+5);
            }
            if(numbers[i]%4 == 0 && numbers[i]%6 == 0){
                map.put(numbers[i],map.getOrDefault(numbers[i],0)+4);
            }
            if(numbers[i]%2==0){
                map.put(numbers[i],map.getOrDefault(numbers[i],0)+3);

            }
        }



        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet()) ;
        Collections.sort(list,(I1,I2) -> I1.getValue() -I2.getValue());
        System.out.println(list);
    }

    private static boolean isPerfectSqaure(int number) {
        for (int i = 1; i < number; i++) {
            if(i*i>number){
                return false;
            }
            if(i*i == number){
                return true;
            }
        }
        return false;
    }
}
