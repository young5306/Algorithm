import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] volume = new int[N];
			int[] cost = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				volume[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			// 1. 0~K부피까지 고려
			// 2. 정보 저장
			// 3. 메모테이블(dp) 만들기
			int[] dp = new int[K+1]; // 0~K
			// 4. 비교
			for (int i = 0; i < N; i++) {
				for (int k = K; k >= volume[i]; k--) {
					dp[k] = Math.max(dp[k], dp[k-volume[i]]+cost[i]);
				}
			}
			
			System.out.println("#"+tc+" "+dp[K]);
		}

	}

}
