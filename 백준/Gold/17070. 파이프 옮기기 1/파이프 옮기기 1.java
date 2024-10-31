

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 우, 우하, 하
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	static int N, cnt;
	static int[][] map;
	// 상좌
	static int[] cr = { -1, 0 };
	static int[] cc = { 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 파이프 마지막칸만 확인 (0,1)시작 -> (N-1,N-1)도달
		// 이동 가능한 곳 (우, 우하, 하) - 우하일때만 상좌 빈칸인지 추가 체크

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int startR = 0;
		int startC = 0;
		int endR = 0;
		int endC = 1;
		cnt = 0;
		dfs(startR, startC, endR, endC);

		System.out.println(cnt);

	} // main

	static void dfs(int sr, int sc, int er, int ec) {
		// 기저 조건
		if (er == N - 1 && ec == N - 1) {
			cnt++;
//			System.out.println("finish: " + cnt);
			return;
		}

		// 재귀 부분

		// 가로 - 우, 우하
		if (sr == er) {
			for (int d = 0; d < 2; d++) {
				int nr = er + dr[d];
				int nc = ec + dc[d];
				if(available(nr, nc, d)) {
					dfs(er, ec, nr, nc);
				}
			}
		}
		// 세로 - 우하, 하
		else if (sc == ec) {
			for (int d = 1; d < 3; d++) {
				int nr = er + dr[d];
				int nc = ec + dc[d];
				if(available(nr, nc, d)) {
					dfs(er, ec, nr, nc);
				}
			}
		}
		// 대각선 - 우, 우하, 하
		else {
			for (int d = 0; d < 3; d++) {
				int nr = er + dr[d];
				int nc = ec + dc[d];
				if(available(nr, nc, d)) {
					dfs(er, ec, nr, nc);
				}
			}
		}
		
	}

	static boolean diagonal(int r, int c) {
		for (int d = 0; d < 2; d++) {
			int nr = r + cr[d];
			int nc = c + cc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
				continue;
			}
			return false;
		}
		return true;
	}
	
	static boolean available(int nr, int nc, int d) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
			if (d == 1) {
				if (!diagonal(nr, nc)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
