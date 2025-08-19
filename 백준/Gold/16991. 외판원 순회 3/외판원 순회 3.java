
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// dfs + 비트마스킹 + dp메모이제이션
	
	static int FULL;
	static double[][] dp;
	static double[][] W;
	static final double INF = 100000;
	static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] city = new int[N][2];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			city[i][0] = Integer.parseInt(st.nextToken());
			city[i][1] = Integer.parseInt(st.nextToken());
		}
		
		W = new double[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				double dist = Math.sqrt(Math.pow(city[i][0] - city[j][0], 2) + Math.pow(city[i][1] - city[j][1], 2));
				W[i][j] = dist;
				W[j][i] = dist;
			}
		}
		
		// tsp
		FULL = (1 << N) - 1;
		dp = new double[FULL + 1][N];
		for(double[] d : dp) {
			Arrays.fill(d, -1);
		}

		System.out.println(tsp(1, 0)); // 방문상태, 현재도시
	}
	
	static double tsp(int mask, int u) {
		// 기저 조건
		if(mask == FULL) {
			if(W[u][0] != 0) return W[u][0];
			return INF;
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
