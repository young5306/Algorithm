
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] W;
	static int FULL;
	static final int INF = 10000000;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// tsp : dfs + dp 메모이제이션 + 비트마스킹
		FULL = (1 << N) - 1; // 1111
		dp = new int[FULL + 1][N];
		for(int[] d : dp) {
			Arrays.fill(d, -1);
		}
		int ans = tsp(1, 0); // 방문상태, 시작도시0번 전달 // tsp에 남은 비용 저장
		
		System.out.println(ans);
	}
	
	static int tsp(int mask, int u) {
		// 기저 조건
		if(mask == FULL) {
			if(W[u][0] != 0) return W[u][0];
			else return INF;
		}
		// 재귀 부분
		if(dp[mask][u] != -1) return dp[mask][u];
		
		dp[mask][u] = INF;
		
		for(int v = 0; v < N; v++) {
			if((mask & (1 << v)) != 0) continue; // 이미 방문
			if(W[u][v] == 0) continue; // 경로 없음
			
			dp[mask][u] = Math.min(dp[mask][u], W[u][v] + tsp(mask | (1 << v), v));
		}
		
		return dp[mask][u];
	}

}
