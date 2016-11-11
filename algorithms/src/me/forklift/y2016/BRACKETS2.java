package me.forklift.y2016;

import java.util.Scanner;
import java.util.Stack;

/*---------------------------------------------
 * https://algospot.com/judge/problem/read/BRACKETS2
---------------------------------------------*/
public class BRACKETS2 {    

    private static char[] OPEN_SYMBOLS = {'(', '[', '{'};
    private static char[] CLOSE_SYMBOLS = {')', ']', '}'};
    
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
    
    public static String solve(String arr) {
        Stack<Character> stack = new Stack<Character>();
        char[] symbols = arr.toCharArray();
        
        for(int ii = 0; ii < symbols.length; ii++) {            
            if (hasItem(OPEN_SYMBOLS, symbols[ii]) > -1)
                stack.add(symbols[ii]);
            else {
                int jj = hasItem(CLOSE_SYMBOLS, symbols[ii]);
                if (jj == -1) return "NO";
                //in case of close_symbol, stack should be not null && should be same as paired close symbol.
                if (stack.isEmpty() || stack.pop() != OPEN_SYMBOLS[jj]) return "NO";                    
            }   
        }        
        
        return stack.isEmpty()?"YES":"NO";
    }
    
    public static int hasItem(char[] items, char item) {
        for(int ii = 0; ii < items.length; ii++) {
            if (items[ii] == item)
                return ii;
        }
        
        return -1;
    }


    

}    

    
