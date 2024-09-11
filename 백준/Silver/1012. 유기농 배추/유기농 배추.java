
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, cnt;
	static int[][] field;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		// 농약 대신 배추흰지렁이로 해충 퇴치
		// 인접(상하좌우)한 곳으로 이동 가능
		// 출력 : 필요한 최소 지렁이 수
		// => 치즈도둑 : 덩어리 개수 구하는 것과 유사한 것 같다. (day만 없음)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로M
			N = Integer.parseInt(st.nextToken()); // 세로N
			K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
			// 상하좌우가 인접한 곳들이어서 인접리스트 따로 필요 없음
			field = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				field[r][c] = 1;
			}

			// dfs
			visited = new boolean[N][M];
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && field[r][c] == 1) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}

	}

	static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && field[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

}
