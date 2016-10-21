package me.forklift.y2016;

/*
다음 식에서 ‘*’ 문자는 ‘+’ 또는 ‘-’ 연산자를 할당할 수 있으며, x를 만족하는 가장 작은 양의 정수 n을 구하시오.
* 1 * 2 * . . . * n = x
예를 들면 x = 12일 경우 이를 만족하는 가장 작은 양의 정수 n = 7이다.
- 1 + 2 + 3 + 4 + 5 + 6 - 7 = 12
[입력 방식]
첫 줄에는 테스트 총 개수가 주어진다.
입력된 각 정수 x는 (0 ≤ |x| ≤ 1000000000)을 만족한다.
입력된 각 정수 x는 한 줄에 하나의 값으로 주어진다.
[출력 방식]
주어진 x를 만족하는 가장 작은 양의 정수 n (1 ≤ n)을 출력한다.
각각의 결과는 한 줄로 나누어 출력한다.
[입력 샘플]
2
12
-3646397
[출력 샘플]
7
2701
*/
public class FindN {

    public static void main(String[] args) {
        int foundN = findNum(3646397);
        System.out.println(foundN);
    }
    
    public static int findNum(int x) {
        int n = 2;
        int maxValueOfFrontStep = 1;
        
        x = Math.abs(x);

        while (true) {            
            if (findNum(x, n, maxValueOfFrontStep)) 
                return n;
            else {
                maxValueOfFrontStep += n;
                n++;                
            }
                
        }
            
    }
    public static boolean findNum(int x, int n, int maxValueOfFrontStep) {
        
        int maxValue = n + maxValueOfFrontStep;
        
        System.out.println("N is " + n + " and max value of this step is " + maxValue);
        
        for(; maxValue >= 0; maxValue -= 2) {
            if (maxValue  == x)
                return true;
            else if (maxValue < x)
                continue;
        }
        
        return false;

    }


}
