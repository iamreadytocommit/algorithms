package me.forklift.y2016;

import java.util.Scanner;
import java.util.Stack;

/*-----------------------------------------------------
https://algospot.com/judge/problem/read/FIXPAREN
-----------------------------------------------------*/
public class FIXPAREN {    
    
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
        Stack<Integer> stack = new Stack<Integer>();
        String expression = arr.split(" ")[0];
        String priority = arr.split(" ")[1];
        
        String answer = "";
        String str = "";
        
        for(int ii = 0; ii < expression.length(); ii++) {
            char currCh = expression.charAt(ii);
            int currId = getParenthesislId(currCh);
            
            //in case of open parenthesis , store it to stack
            if (isOpenParenthesis(currCh))
                stack.push(currId);
            else {
                //compare current parenthesis with popped parenthesis from stack 
                int choosedParenthesis = getNeedParenthesisId(stack.pop(), currId, priority);
                
                str = makeString(choosedParenthesis, str);
            }
            
            if (stack.isEmpty()) {
                answer += str;
                str = "";
            }                
        }

        return answer;
    }
    
    //make expression using parenthesis id 
    public static String makeString(int id, String str) {
        switch(id) {
        case 0 : return "<" + str + ">";
        case 1 : return "(" + str + ")";
        case 2 : return "{" + str + "}";
        case 3 : return "[" + str + "]";
        default : return "";
        }
    }
    
    //define id for each parenthesis
    public static int getParenthesislId(char ch) {
        String symbol = String.valueOf(ch);
        return "<>".contains(symbol)? 0 :
               "()".contains(symbol)? 1 :
               "{}".contains(symbol)? 2 :    
               "[]".contains(symbol)? 3 : -1;
    }
    
    public static boolean isOpenParenthesis(char ch) {
        return "[{<(".contains(String.valueOf(ch));
    }
    
    public static boolean isCloseParenthesis(char ch) {
        return "]}>)".contains(String.valueOf(ch));
    }
    
    //compare rank with stored & current parenthesis and return high ranked parenthesis
    public static int getNeedParenthesisId(int stored, int current, String priority) {
        for(int ii = 0; ii < priority.length(); ii++) {
            int id = getParenthesislId(priority.charAt(ii));
            if (stored == id) return stored;
            if (current == id) return current;
        }
        return -1;
    }
}    

    
