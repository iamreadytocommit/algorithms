package me.forklift.y2016;

import java.util.Arrays;
import java.util.Scanner;

/*------------------------------------------
https://algospot.com/judge/problem/read/XHAENEUNG
------------------------------------------*/
public class XHAENEUNG {    

    //sorted by each character 
    private static String[] sortedNumbers = {
            "eorz", "eno", "otw", "eehrt", "foru", 
            "efiv", "isx", "eensv", "eghit", "einn", "ent"
    };      

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
        
        String[] buf = in.split(" ");
        int x = getNumber(buf[0]);
        int y = getNumber(buf[2]);
        int z = getNumber(buf[4]);
        String op = buf[1];
        int result = 0;
        
        switch(op) {
        case "+" : result = x+y; break;
        case "-" : result = x-y; break;
        case "*" : result = x*y; break;        
        case "/" : result = x/y; break;
        }
        
        //couldn't parse cases
        if (x == -1 || y == -1 || z == -1)
            return "No";

        if (result < 0 || result > 10)
            return "No";
        else
            return (z == result) ? "Yes" : "No";
    }
    
    //sort by each character unit & compare with sortedNumbers array
    public static int getNumber(String str) {
        char[]  tmp = str.toCharArray();
        Arrays.sort(tmp);
        
        String number = new String(tmp);

        for(int ii = 0; ii < sortedNumbers.length; ii++) {
            if (number.equals(sortedNumbers[ii]))
                return ii;
        }
        
        return -1;
        
    }

}    
