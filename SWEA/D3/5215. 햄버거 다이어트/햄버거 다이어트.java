

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    // 주어진 제한 칼로리 이하의 조합 중 가장 맛점수가 높은 햄버거의 점수
    // 부분집합

    static boolean[] sel;
    static int[] taste;
    static int[] calory;
    static int N, L, tasteSum, calorySum, tasteMax;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            taste = new int[N];
            calory = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());
            }

//            System.out.println(Arrays.toString(taste));
//            System.out.println(Arrays.toString(calory));

            // 부분집합 (재귀)
            tasteMax = 0;
            perm(0, 0, 0); // idx, tasteSum, calorySum

            System.out.println("#"+tc+" "+tasteMax);
        } // for tc
    } // for main

    public static void perm(int idx, int tasteSum, int calorySum){
        // 기저 조건
        if(calorySum > L) {
            tasteMax = Math.max(tasteMax, tasteSum-taste[idx-1]);
            return;
        }
        if(idx == N) {
            tasteMax = Math.max(tasteMax, tasteSum);
            return;
        }

//        System.out.println(idx+", "+tasteSum+", "+calorySum);
        
        // 사용
        perm(idx+1, tasteSum+taste[idx], calorySum+calory[idx]);
        // 사용 x
        perm(idx+1, tasteSum, calorySum);
    }
}
