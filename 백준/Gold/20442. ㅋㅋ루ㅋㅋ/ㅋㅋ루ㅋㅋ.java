

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int rCnt = 0;
		
		// 1. R 개수 세기
		for (int i = 0; i < len; i++) {
			if(str.charAt(i)=='R') rCnt++;
		}
		
		if(rCnt==0 || len==0) {
			System.out.println(0);
			return;
		}
		
		int lp = 0;
		int rp = len-1;
		int lk = 0; // K의 수
		int rk = 0;
		// 2. 왼쪽, 오른쪽 K수 확인
		while(str.charAt(lp)=='K') {
			lk++;
			lp++;
		}
		while(str.charAt(rp)=='K') {
			rk++;
			rp--;
		}
		// 3. 문자열 계산
		int max = 0;
		max = rCnt + Math.min(lk, rk)*2;
		
		// 4. 포인터 한쪽씩 움직음 (K수가 작은 쪽을 갱신)
		while(lp<=rp && rCnt>0) {
			
			if(lk < rk) {
				while(lp<=rp && str.charAt(lp)=='R') {
					lp++;
					rCnt--;
				}
				while(lp<=rp && str.charAt(lp)=='K') {
					lk++;
					lp++;
				}
			} else {
				while(lp<=rp && str.charAt(rp)=='R') {
					rp--;
					rCnt--;
				}
				while(lp<=rp && str.charAt(rp)=='K') {
					rk++;
					rp--;
				}
			}
			
			max = Math.max(max, rCnt + Math.min(lk, rk)*2);
			
		}
		
		System.out.println(max);
		

	}

}
