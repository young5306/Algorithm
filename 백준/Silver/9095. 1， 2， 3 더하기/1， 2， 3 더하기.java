
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// dp 느낌 (경우의 수 : 순서 고려)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1]; // 0~N
			
			for (int i = 0; i <= N; i++) {
				// 1만 사용하는 경우
				dp[i] = 1;
				// 1,2 사용하는 경우
				if(i>=2) dp[i] = dp[i-1] + dp[i-2];
				// 1,2,3 사용하는 경우
				if(i>=3) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[N]);
		}

	}

}
