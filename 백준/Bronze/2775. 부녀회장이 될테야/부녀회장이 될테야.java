

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			
			int[] dp = new int[n+1]; // 1~n
			for (int i = 1; i <= n; i++) {
				dp[i] = i; // 0층	
			}
			
			// 최종 dp[n] 구하기
			// dp[n호] = 아래층 (dp[1호] + ... + dp[n-1호])
			for (int f = 1; f <= k; f++) {
				for (int i = n; i >= 1; i--) {
					for (int j = i-1; j > 0; j--) {
						dp[i] += dp[j];
					}
				}
			}
			
//			System.out.println(Arrays.toString(dp));
			System.out.println(dp[n]);
			
		}

	}

}
