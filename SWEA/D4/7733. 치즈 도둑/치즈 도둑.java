
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution { // 덩어리세기 bfs

	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 1; // 0일에 덩어리 1개

			// n일 - n초과 치즈만 셈
			for (int day = 1; day <= 100; day++) {
				visited = new boolean[N][N];

				int cnt = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// bfs
						if (!visited[r][c] && board[r][c] > day) {
//							System.out.println(r+","+c);
							bfs(day, r, c);
							cnt++;
						}
					}
				}

				max = Math.max(max, cnt);
			}

			System.out.println("#" + tc + " " + max);
		}

	}

	static void bfs(int day, int x, int y) {
		visited[x][y] = true;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc] > day) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

}
