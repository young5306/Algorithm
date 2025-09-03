
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] board;
	static int max, maxCell;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i  = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j  = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxCell = Math.max(maxCell, board[i][j]);
			}
		}
		
		visited = new boolean[N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, board[r][c], 1); // (r, c, sum, depth)
				visited[r][c] = false;
			}
		}
		
		System.out.println(max);

	}
	
	static void dfs(int r, int c, int sum, int depth) {
		// 기저 조건
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		// 가지치기
		int upper = sum + (4 - depth) * maxCell;
		if(upper <= max) return;
		
		// 재귀 부분
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
				
				if(depth == 2) { // ㅗ 모양 위해 한번 더 탐색
					visited[nr][nc] = true;
					dfs(r, c, sum + board[nr][nc], depth + 1); // r,c 기존 위치 고정
					visited[nr][nc] = false;
				}
				
				visited[nr][nc] = true;
				dfs(nr, nc, sum + board[nr][nc], depth + 1);
				visited[nr][nc] = false;
			}
		}
	}
}
