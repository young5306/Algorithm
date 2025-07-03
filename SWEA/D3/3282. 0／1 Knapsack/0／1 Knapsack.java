
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
						
			int[] volume = new int[N];
			int[] cost = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				volume[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[K+1]; // 각 부피에서 최대가치 저장 및 갱신
			// 1번~N번 물건들을 차근차근 확인
			// 각 물건을 누적해가며 K~0부피(역순) 차근차근 확인
			for(int i=0; i<N; i++) {
				for(int k=K; k >= volume[i]; k--) {
					dp[k] = Math.max(dp[k], dp[k-volume[i]] + cost[i]);
				}
			}
			
			System.out.println("#"+tc+" "+dp[K]);
		}

	}

}
