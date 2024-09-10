import java.util.Scanner;

public class Solution {
	
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
			
			// 1. 1~100일 동안 각 날마다 매번 모든 요소 돌기
			// 2. 시작점 : 매번 (0,0)부터 방문안한, day보다 큰 곳 방문해서 dfs 
			// 3. 다음 dfs 조건 : (nr,nc)가 board 범위 내, visited 안한 곳, day보다 큰 곳
			// 4. visited 조건 : 각 날짜마다 방문할 수 있는 곳(day 초과) 중에서만 방문 체크 (날마다 초기화-덩어리 다시 세야해서)
			// cnt(덩어리세기) 언제 하나 : 시작점 dfs순회 끝날때 cnt+1해서 덩어리 세기, visited는 초기화
			// 다음 day에서 반복 : 다음 위치는 day보다 큰 곳부터 시작
			
			int max = 1; // 0일에는 한덩어리
			for (int day = 1; day <= 100; day++) { // 1.
				
				visited = new boolean[N][N]; // 4.
				int cnt = 0;
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(board[r][c]>day && !visited[r][c]) { // 2.
							visited[r][c] = true;
							dfs(r,c, day);
							cnt++;
						}
					}
				}
				
				max = Math.max(max, cnt);
				
			}
			
			System.out.println("#"+tc+" "+max);
		} // tc

	} // main
	
	static void dfs(int r, int c, int day) { 
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && board[nr][nc]>day) { // 3.
				visited[nr][nc] = true;
				dfs(nr, nc, day);
			}
		}
	}
	
	// 나는 day보다 작은거 일단 다 visited 표시 후 board 또 돌면서 덩어리 셈
	// 강사님 풀이 : board[nr][nc]>day 조건으로 day보다 작은거 그냥 무시 => 연산 훨씬 줆

}
