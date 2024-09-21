
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { // 1차배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); //  제한 칼로리
			
			// N개 재료의 맛점수, 칼로리 저장 배열
			int[] score = new int[N];
			int[] calory = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[L+1]; // 0~L칼로리
			for (int i = 0; i < N; i++) {
				// 각 재료에 대해 현재 재료의 칼로리보다 높은 부분만 갱신
				for (int cal = L; cal >= calory[i]; cal--) { // 역순으로 해야 이전 배열에서 갱신
					dp[cal] = Math.max(dp[cal], dp[cal-calory[i]]+score[i]);
				}
				
			}
			// 왜 다 이렇게 푸는 거지
			System.out.println("#"+tc+" "+dp[L]);
			
		}
	}

}
