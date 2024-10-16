import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// (순열+중복)으로 하면 터진다!
		// dp[K][N] = dp[k-1][0~N전부] = dp[K][N-1] + dp[K-1][N]

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] dp = new long[N+1]; // 0~N
		dp[0] = 1; // 초기화 (1 0 0 0 ...)

		for (int k = 1; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				dp[n] = (dp[n] + dp[n-1])%1000000000;
			}
		}
		
		System.out.println(dp[N]%1000000000);

	}

}
