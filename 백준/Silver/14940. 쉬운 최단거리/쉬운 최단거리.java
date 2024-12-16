

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 상우하좌
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1}; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int startR = 0;
		int startC = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==2) {
					startR = i;
					startC = j;
				}
			}
		} // 입력 완료
		
		boolean[][] visited = new boolean[n][m];
		// bfs
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startR, startC, 0});
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			int level = place[2];
			map[r][c] = level;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc]==1) {
					q.add(new int[] {nr, nc, level+1});
					visited[nr][nc] = true;
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					map[i][j] = -1; 
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
		
	}

}
