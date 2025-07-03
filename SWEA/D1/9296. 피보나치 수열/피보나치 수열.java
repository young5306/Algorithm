
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1 1 2 3 5 ...
		for(int i=0; i<5; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N];
			dp[0] = 1;
			dp[1] = 1;
			
			// dp 시작
			for(int j=2; j<N; j++) {
				dp[j] = dp[j-1] + dp[j-2];
			}
			
			System.out.println(dp[N-1]);
		}
	}
}
