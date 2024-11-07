

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	// 2방향 탐색 (우상, 좌상) // 상은 check로 검사
	static int[] dr = { -1, -1 };
	static int[] dc = { -1, 1 };
	static int N, cnt;
	static int[][] board;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		check = new boolean[N]; // 열

		// dfs
		cnt = 0;
		dfs(0);

		System.out.println(cnt);
	}

	static void dfs(int depth) {
		// 기저 조건
		if (depth == N) {
			cnt++;
			return;
		}

		// 재귀 부분
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				if (isAvailable(depth, i)) {
					check[i] = true;
					board[depth][i] = 1;
					dfs(depth + 1);

					check[i] = false;
					board[depth][i] = 0;
				}
			}
		}

	}

	static boolean isAvailable(int depth, int v) {
		for (int d = 0; d < 2; d++) {
			int r = depth;
			int c = v;

			while (r >= 0 && r < N && c >= 0 && c < N) {
				r += dr[d];
				c += dc[d];
				if (r >= 0 && r < N && c >= 0 && c < N && board[r][c] == 1)
					return false;
			}
		}
		return true;
	}

}
