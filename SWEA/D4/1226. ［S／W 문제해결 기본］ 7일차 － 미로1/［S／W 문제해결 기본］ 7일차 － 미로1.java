import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] maze;
	static boolean[][] visited;
	static boolean flag;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int T = Integer.parseInt(br.readLine());
			
			maze = new int[16][16];
			int startR = 0;
			int startC = 0;

			for (int r = 0; r < 16; r++) {
				String str = br.readLine();
				for (int c = 0; c < 16; c++) {
					int num = str.charAt(c) - '0';
					maze[r][c] = num;
					if(num == 2) {
						startR = r;
						startC = c;
					}
				}
			}
			
			visited = new boolean[16][16];
			flag = false;
			dfs(startR, startC);
			
			System.out.println("#"+tc+" "+ (flag?1:0));
		}
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		if(maze[r][c]==3) {
			flag = true;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!visited[nr][nc] && maze[nr][nc]!=1) {
//				System.out.println(nr+","+nc);
				dfs(nr, nc);
			}
		}
	}

}
