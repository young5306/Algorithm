import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution { // BFS
	
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			} // 입력 완료
			
			// bfs
			// 1. 1~100일 동안 각 날마다 매번 모든 요소 돌기
			// 2. 시작점 : 매번 (0,0)부터 방문안한, day보다 큰 곳 방문
			// 3. bfs 시작 : queue에 시작점 넣고, 방문체크
			// while : 시작점 빼면서 인접점(nr,nc) 넣음 
			// 인접점(nr,nc) 조건 : board 범위 내, day보다 크고, 방문 안한 곳
			// 4. visited 조건 : 각 날짜마다 방문할 수 있는 곳(day 초과) 중에서만 방문 체크 
			// visited는 날마다 초기화-덩어리 다시 세야해서
			// cnt(덩어리세기) 언제 하나 : queue 다 빠질 때마다 cnt+1 (cnt도 날마다 초기화)
		
			int max = 1;
			for (int day = 1; day <= 100; day++) { // 1.
				
				visited = new boolean[N][N];
				int cnt = 0;
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!visited[r][c] && board[r][c]>day) {
							bfs(r, c, day);
							cnt++;
						}
					}
				}
				
				max = Math.max(max, cnt);
				
			}
			
			System.out.println("#"+tc+" "+max);
		} // tc

	} // main
	
	static void bfs(int r, int c, int day) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = place[0] + dr[d];
				int nc = place[1] + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && board[nr][nc]>day) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
	}


}
