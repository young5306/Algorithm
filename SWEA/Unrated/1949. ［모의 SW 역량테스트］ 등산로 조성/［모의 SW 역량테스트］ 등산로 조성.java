import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, max;
	static int[][] mountain;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 입력받으면서 높은 봉우리 확인
		// 높은 지형에서 낮은 지형으로 연결
		// 한곳만 최대 K 깎을 수 있음
		// 가장 긴 등산로 찾기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mountain = new int[N][N];
			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					mountain[i][j] = n;
					maxHeight = Math.max(maxHeight, n);
				}
			}

			max = 1;
			// 전체 돌면서 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					visited = new boolean[N][N];
					if (mountain[r][c] == maxHeight) {
						dfs(r, c, 1, true); // true : 깎을 수 있다.
					}
				}
			}

			System.out.println("#" + tc + " " + max);

		} // tc
	} // main

	static void dfs(int r, int c, int level, boolean available) {
		max = Math.max(max, level);
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				int sub = mountain[nr][nc] - mountain[r][c];
				// 낮을 때 다음 dfs 돌기
				if (sub < 0) {
					dfs(nr, nc, level + 1, available);
				}
				// 높거나 같을 때 깎을 수 있는지 확인하고 깎기
				else if (available && sub < K) {
					int tmp = mountain[nr][nc];
					mountain[nr][nc] = mountain[r][c] - 1;
					dfs(nr, nc, level + 1, !available);
					mountain[nr][nc] = tmp;
				}
			}
		}
		
		visited[r][c] = false;
	}

}
