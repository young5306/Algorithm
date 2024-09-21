import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 5; tc++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(fibo(N));
		}
		

	}
	
	static int fibo(int n) {
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			if(dp[i] == 0) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		
		return dp[n];
	}

}
