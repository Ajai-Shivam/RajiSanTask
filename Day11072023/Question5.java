package Day11072023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfRelationship = sc.nextInt();
        String [][] relationShip = new String[numberOfRelationship][2];
        for (int i = 0; i < numberOfRelationship; i++) {
            relationShip[i][0] = sc.next();
            relationShip[i][1] = sc.next();
        }

        HashMap<String,ArrayList<String>> adjList = new HashMap<>();

        String nameOfGrandFather = sc.next();
        // Using Graph adjacent list algorithm

        for (int i = 0; i < numberOfRelationship; i++) {
            if(adjList.containsKey(relationShip[i][1])){
                adjList.get(relationShip[i][1]).add(relationShip[i][0]);
            }else {
                adjList.put(relationShip[i][1],new ArrayList<>());
                adjList.get(relationShip[i][1]).add(relationShip[i][0]);
            }
        }

        ArrayList<String> grandFatherSons = new ArrayList<>();

        grandFatherSons= adjList.get(nameOfGrandFather);

        // Number of GrandParents
        int ans = 0;
        for (int i = 0; i < grandFatherSons.size(); i++) {
            ans += adjList.get(grandFatherSons.get(i)).size();
        }

        System.out.println(ans);


    }
}
