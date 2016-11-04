package me.forklift.y2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*--------------------------------------------------- 
 * https://algospot.com/judge/problem/read/WEIRD
----------------------------------------------------*/
public class WeirdNumber {

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
        int sum = 0;
        List<Integer> divisors = getDivisors(Integer.valueOf(in).intValue());

        for(int x : divisors) {
            sum += x;
        }        
        if (sum < Integer.valueOf(in).intValue())
            return "not weird";
        
        //Sum(divisors) - origin number => if it could be subset of divisor, it's not weird number. 
        sum = sum - Integer.valueOf(in).intValue(); 

        return isWieredNumber(divisors, 0, 0, sum) ? "weird" : "not weird";
    }    

    
    public static boolean isWieredNumber(List<Integer> list, int ii, int sum, int num) {
        
        if (ii >= list.size())
            return true;        

        //try to find subset equal to find num
        if (sum == num || sum+list.get(ii) == num)
            return false;
        else {
            return isWieredNumber(list, ii+1, sum, num) &&
                    isWieredNumber(list, ii+1, sum+list.get(ii), num);
        }        
    }    

    public static List<Integer> getDivisors(int in) {        

        int tryMaxNum = (int)Math.sqrt(in);
        List<Integer> divisors = new ArrayList<Integer>();
        
        divisors.add(1);
        for(int ii = 2; ii <= tryMaxNum; ii++) {
            if (in % ii == 0) { 
                divisors.add(ii);
                if (ii != in / ii)
                    divisors.add(in / ii);
            }
        }
        
        return divisors;
    }
}
