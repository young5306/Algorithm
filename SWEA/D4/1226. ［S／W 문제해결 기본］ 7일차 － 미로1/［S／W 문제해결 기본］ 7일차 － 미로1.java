
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution { // bfs
	static int[][] maze;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	static int flag;

	public static void main(String[] args) throws Exception {
		
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
			
			
			// bfs
			// queue에 시작점 넣기
			// 시작점 poll하고 시작점과 연결된 인접점 넣기
			// 인접점(nr,nc) 조건 : 0이나 3 (3이면 바로 break)
			// visited : 2차배열 대신 지나온 거리 벽1로 바꾸자
			flag = 0;
			bfs(startR, startC);
			
			System.out.println("#"+T+" "+flag);
			
		} // tc

	} // main
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		maze[r][c] = 1;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = place[0] + dr[d];
				int nc = place[1] + dc[d];
				
				if(maze[nr][nc]==0) {
					maze[nr][nc]=1;
					q.add(new int[] {nr, nc});
				} else if(maze[nr][nc]==3) {
					flag = 1;
					return;
				}
			}
		}
	}

}
