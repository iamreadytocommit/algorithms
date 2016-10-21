package me.forklift.y2016;

/*
���� �Ŀ��� ��*�� ���ڴ� ��+�� �Ǵ� ��-�� �����ڸ� �Ҵ��� �� ������, x�� �����ϴ� ���� ���� ���� ���� n�� ���Ͻÿ�.
* 1 * 2 * . . . * n = x
���� ��� x = 12�� ��� �̸� �����ϴ� ���� ���� ���� ���� n = 7�̴�.
- 1 + 2 + 3 + 4 + 5 + 6 - 7 = 12
[�Է� ���]
ù �ٿ��� �׽�Ʈ �� ������ �־�����.
�Էµ� �� ���� x�� (0 �� |x| �� 1000000000)�� �����Ѵ�.
�Էµ� �� ���� x�� �� �ٿ� �ϳ��� ������ �־�����.
[��� ���]
�־��� x�� �����ϴ� ���� ���� ���� ���� n (1 �� n)�� ����Ѵ�.
������ ����� �� �ٷ� ������ ����Ѵ�.
[�Է� ����]
2
12
-3646397
[��� ����]
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
