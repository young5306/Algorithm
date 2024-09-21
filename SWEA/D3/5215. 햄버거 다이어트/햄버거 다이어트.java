import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { // 2차 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); //  제한 칼로리
			
			// N개 재료의 맛점수, 칼로리 저장 배열
			int[] score = new int[N+1];
			int[] calory = new int[N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}
			// 칼로리 이하 조합 중 선호도 가장 높은 버거
			// 1. 0부터 칼로리L까지 확인
			// 2. 재료 정보 저장
			// 3. 메모테이블
			int[][] dp = new int[N+1][L+1]; // 0~N개, 0~L칼로리
			// 4. 비교 - 최대 구하기 (0행에 최소값 0 저장)
			for (int i = 1; i <= N; i++) {
				for (int cal = 1; cal <= L; cal++) {
					if(calory[i]<=cal) {
						dp[i][cal] = Math.max(dp[i-1][cal], dp[i-1][cal-calory[i]]+score[i]);
						// 재료 한번만 사용하게 됨 (0행이 모두 0이라서)
						// 동전에서는 0행에 01234567.. 넣어줌
					} else {
						dp[i][cal] = dp[i-1][cal];
					}
				}
			}
			
			System.out.println("#"+tc+" "+dp[N][L]);
			
		}
	}

}
