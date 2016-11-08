package me.forklift.y2016;

import java.util.Scanner;

/*------------------------------------------
https://algospot.com/judge/problem/read/NQUEEN
------------------------------------------*/
public class NQUEEN {    

    private static int[][] BOARD;
    private static int SIZE;
    private static int GOAL;
    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine()).intValue();
        String[] arr = new String[cases];
        String[] answers = new String[cases];

        for (int xx = 0; xx < cases; xx++) {
            arr[xx] = sc.nextLine();
            answers[xx] = solve(arr[xx]);
        }

        for (String answer : answers) {
            System.out.println(answer);
        }

    }
    
    public static String solve(String in) {
        //set condition from input
        SIZE = Integer.valueOf(in);
        BOARD = new int[SIZE][SIZE];
        GOAL = 0;
        findQueen(0);
        return String.valueOf(GOAL);        
    }
    
    public static boolean findQueen(int row) {
        
        //base case 
        if (row >= SIZE)
            return true;
        
        for(int col =0; col < SIZE; col++) {
            if (isAppropriatePosition(row, col)) {
                BOARD[row][col] = 1;
                if (findQueen(row+1)) GOAL++;
                BOARD[row][col] = 0;                
            }        
        }
        
        return false;
    }
    
    //determine whether appropriate position or no
    public static boolean isAppropriatePosition(int row, int col) {        
        //check each row
        for(int currRow = 0; currRow < SIZE; currRow++) {
            int gap = Math.abs(currRow - row);
            if (gap == 0) continue;
            //try to find queen on same column
            if (BOARD[currRow][col] == 1) return false;
            //try to find queen on diagonal position
            if (row-gap >= 0   && col-gap >= 0   && BOARD[row-gap][col-gap] == 1) return false;
            if (row+gap < SIZE && col+gap < SIZE && BOARD[row+gap][col+gap] == 1) return false;
            if (row-gap >= 0   && col+gap < SIZE && BOARD[row-gap][col+gap] == 1) return false;            
            if (row+gap < SIZE && col-gap >= 0   && BOARD[row+gap][col-gap] == 1) return false;            
        }

        return true;
    }

}    

    
