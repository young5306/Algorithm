

import java.util.Scanner;

public class Solution {
	
	static int[] cnt;
	static int[] nums;
	static int N;
	
	static int max;
	static int min;

	public static void main(String[] args) {
		// 중복된 입력값 있음 -> visit배열을 cnt배열로 대체
		// 순서O - 순열
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			nums = new int[N];
			cnt = new int[4];
			
			for (int i = 0; i < 4; i++) {
				cnt[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			
			max = -100000001;
			min = 100000001;
			// 연산자 배치
			perm(0, nums[0]); // sidx
			
			
			
			System.out.println("#"+t+" "+(max-min));
		}
	}
	
	static void perm(int sidx, int res){ // 중간 연산 값 들고 다니기
		// 기저 조건
		if(sidx==N-1) {
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}
		
		// 재귀 부분
		for (int op = 0; op < 4; op++) {
			if(cnt[op]>0) {
				cnt[op]--;
				perm(sidx+1, calc(res, nums[sidx+1], op));
				cnt[op]++;
			}
		}
	}
	
	static int calc(int num1, int num2, int op) {
		if(op==0) {
			return num1 + num2;
		} else if(op==1) {
			return num1 - num2;
		} else if(op==2) {
			return num1 * num2;
		} 
		return num1 / num2;
		 
	}
}
