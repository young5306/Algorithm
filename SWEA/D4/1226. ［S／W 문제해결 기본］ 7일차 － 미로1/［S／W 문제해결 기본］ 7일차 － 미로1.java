
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	static int flag;

	public static void main(String[] args) throws Exception {
		
		// 벽1 길0 출발점2 도착점3
		// 입력받으면서 출발점 저장
		// 
		// 출발점부터 dfs -> 인접점(nr,nc)을 dfs 
		// 인접점 조건 : 범위 내에서, 0이면서 방문안한곳 (visited[][] 필요), 3이면 바로 끝내 
		// => 범위 내 조건 필요한가...
		// 가다가 3마주치면 flag == 1, break 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			
			maze = new int[16][16];
			int startR = 0;
			int startC = 0;
			
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					int num = str.charAt(j) - '0';
					maze[i][j] = num;
					if(num==2) {
						startR = i;
						startC = j;
					}
				}
			} // 입력 완료
			
			// dfs
			visited = new boolean[16][16];
			flag = 0;
			dfs(startR, startC);
			
			System.out.println("#"+T+" "+flag);
		} // tc

	} // main
	
	static void dfs(int r, int c) {
		if(flag==1) return; // 3 찾으면 더 진행 안함
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 내 조건 일단 빼보자..
			if(maze[nr][nc]==0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			} else if(maze[nr][nc]==3) {
				flag = 1;
				return;
			}
		}
		
	}

}
