
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] W;
	static int[][] dp; // dp[mask][u]: mask 상태에서 u 도시에 있을 때 남은 최소 비용
	static int FULL; // 모든 도시를 방문했을 때의 상태 비트 (2^N -1)
	static final int INF = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도시 개수 입력 (0번~N-1번)
		N = Integer.parseInt(br.readLine());
		FULL = (1 << N) - 1;
		
		// 비용 행렬 초기화
		StringTokenizer st;
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1 << N][N];
		for(int m = 0; m <= FULL; m++) Arrays.fill(dp[m], -1); // 2^N번 돌면서 -1로 초기화 -> 필요한가
		
		// 0번 도시만 방문한 상태(1), 시작점 0번 도시
		int ans = tsp(1, 0); // (mask, u)
		
		System.out.println(ans);
	}
	
	// mask: 현재까지 방문한 도시 집합(비트마스크)
	// u: 현재 위치한 도시
	// 반환값: 남은 도시를 모두 방문하고 시작0번도시로 돌아가는 최소 비용
	static int tsp(int mask, int u) {
		
		// 1. 기저 조건: 모든 도시를 방문한 경우
		// 시작점으로 가는 길이 없으면 INF 반환, 있으면 해당 거리 반환
		if(mask == FULL) {
			return (W[u][0] == 0) ? INF : W[u][0];
		}
		
		// 2. 재귀 부분
		// 메모이제이션 - 쓰는데가 있나?
		// dp에 뭘 저장하지?: 0~u 까지 가는데 최소 비용? 남은 최소 비용?
		if(dp[mask][u] != -1) return dp[mask][u];
		
		dp[mask][u] = INF;
		
		for (int v = 0; v < N; v++) {
			// 이미 방문한 도시 제외
			if((mask & (1 << v)) != 0) continue;
			// 경로가 없으면 제외
			if(W[u][v] == 0) continue;
			
			// v를 방문하는 비용 = u->v 이동 비용 + 남은 경로 회소 비용
			int cost = W[u][v] + tsp(mask | (1 << v), v); // 0 -> u -> v -> w -> 0
			dp[mask][u] = Math.min(cost, dp[mask][u]);
		}
		
		return dp[mask][u];
	}

}
