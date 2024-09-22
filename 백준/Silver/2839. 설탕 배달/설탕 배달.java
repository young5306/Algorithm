
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 봉지 최소 개수 구하기
		int[] dp = new int[N+1];
		boolean[] available = new boolean[N+1];
		available[0] = true;
		
		for (int i = 1; i <= N; i++) {
			if(i>=3 && available[i-3]) {
				dp[i] = Math.min(987654321, dp[i-3]+1);
				available[i] = true;
			}
			if(i>=5 && available[i-5]) {
				if(available[i]) { // 갱신된 적 있음
					dp[i] = Math.min(dp[i], dp[i-5]+1);
				} else { // 갱신된 적 없음
					dp[i] = Math.min(987654321, dp[i-5]+1);
					available[i] = true;
				}
				
			}
		}
		
		System.out.println(available[N] ? dp[N] : -1);
	} // main

}
