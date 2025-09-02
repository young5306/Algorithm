
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 최대 수익
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int[] pay = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[0]을 구함
		int[] dp = new int[N + 1]; // 퇴사일(N+1)은 0

		// N일 이후에 벌 수 있는 최대 수익
		for(int i = N - 1; i >= 0; i--) {
			if (i + time[i] > N) {
				dp[i] = Math.max(dp[i + 1], dp[i]);
				continue;
			}
			
			dp[i] = Math.max(dp[i + 1], dp[i + time[i]] + pay[i]);
		}
		
		System.out.println(dp[0]);
	}
}
