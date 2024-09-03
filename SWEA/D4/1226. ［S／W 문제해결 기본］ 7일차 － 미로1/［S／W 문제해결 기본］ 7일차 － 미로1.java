

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] board;
	static boolean[][] visited;
	// 상우하좌 순서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean flag;

	public static void main(String[] args) throws Exception {
		// DFS
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			int T = Integer.parseInt(br.readLine());
			
			board = new int[16][16];
			visited = new boolean[16][16];
			
			int r = 0; // 시작점
			int c = 0;
			
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					board[i][j] = str.charAt(j)-'0';
					if(str.charAt(j)=='2') {
						r = i;
						c = j;
					}
				}
			}
			
			flag = false;
			dfs(r,c);
			
			System.out.println("#"+T+" "+ (flag ? 1 : 0));
		} // tc
	} // main
	
	public static void dfs(int r, int c) {
		// 기저 조건
		if(board[r][c]==3) {
			flag = true;
			return;
		}
		
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0 || nr>=16 || nc<0 || nc>=16 || board[nr][nc]==1 || visited[nr][nc]) continue;
			dfs(nr, nc);
			visited[nr][nc] = false;
		}
	}

}
