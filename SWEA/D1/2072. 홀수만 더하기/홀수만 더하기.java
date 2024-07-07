
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                    // double 변수 1개 입력받는 예제
// g = sc.nextByte();                        // char 변수 1개 입력받는 예제
// var = sc.next();                           // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                     // long 변수 1개 입력받는 예제

// 표준 출력 예제
//System.out.println(a);                       // int, double, char, 문자열, long 변수 1개 출력하는 예제

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int sum = 0;
            for(int i=0;i<10;i++){
                int N = sc.nextInt();
                if (N%2==1) sum+=N;
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}