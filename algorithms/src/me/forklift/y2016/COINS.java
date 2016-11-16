package me.forklift.y2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*--------------------------------------------------------
https://algospot.com/judge/problem/read/COINS
--------------------------------------------------------*/
public class COINS {    
    
    private static int goalAmt ;
    private static List<Integer> coins;
    private static List<List<Integer>> combinationOfCoins;
    private static long solutions;
    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine()).intValue();
        String[] arr1 = new String[cases];
        String[] arr2 = new String[cases];
        String[] answers = new String[cases];

        for (int xx = 0; xx < cases; xx++) {
            arr1[xx] = sc.nextLine();          
            arr2[xx] = sc.nextLine();            
            answers[xx] = solve(arr1[xx], arr2[xx]);
        }

        for (String answer : answers) {
            System.out.println(answer);
        }

    }
    
    public static String solve(String arr1, String arr2) {

        solutions = 0;
        goalAmt = Integer.valueOf(arr1.split(" ")[0]);
        coins = new ArrayList<Integer>();
        combinationOfCoins = new ArrayList<List<Integer>>(); 
        
        //insert each coins from parameter to buffer named coins 
        putCoinsInThePocket(arr2);
        
        //make set of possible combinations of each coins
        makePossibleCombination();
        
        //count possible combinations same as goal amount
        makeSameAmount(0, 0);
        
        return String.valueOf(solutions);

    }

    public static void putCoinsInThePocket(String param) {
        for(String coin : param.split(" ")) {
           coins.add(Integer.valueOf(coin));
        }
        
        Collections.sort(coins);
        Collections.reverse(coins);
    }
    
    public static void makePossibleCombination() {
        for(int coin : coins) {            
            int sum = 0;
            ArrayList<Integer> combinations = new ArrayList<Integer>();
            
            while (sum <= goalAmt) {
                combinations.add(sum);
                sum += coin;
            }
            if (!combinations.isEmpty())
                combinationOfCoins.add(combinations);
        }
    }
    
    public static void makeSameAmount(int round, int sum) {
        if (sum == goalAmt) {            
            solutions++;
            return;
        }
        
        if (sum > goalAmt || round >= combinationOfCoins.size())
            return ;
        
        List<Integer> subset = combinationOfCoins.get(round);
        for (int ii : subset) {
            if (sum+ii > goalAmt)
                break;
            else
                makeSameAmount(round+1, sum + ii);
        }
    }
    
}    

    

