

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	// 상우하좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	
	static int[][] dCheck = {{}, {0,1,2,3}, {0,2}, {1,3}, {0,1}, {1,2}, {2,3}, {0,3}};
	// 뺀 파이프 확인
	// 1 - 0123 / 2 - 02 / 3- 13 / 4 - 01 / 5 - 12 / 6 - 23 / 7 - 03
	
	
	public static void main(String[] args) throws Exception {
		
		// 수업 코드 보자.
		// 따라쳐보고 혼자쳐보고 문제 풀자
		// bfs > dijk

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 세로
			int M = Integer.parseInt(st.nextToken()); // 가로
			int R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 위치r
			int C = Integer.parseInt(st.nextToken()); // 위치c
			int L = Integer.parseInt(st.nextToken()); // 탈출 후 소요 시간
			
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료
			
			// bfs - R,C 부터 시작
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			visited[R][C] = true;
			queue.add(new int[] {R, C, 1}); // r, c, level
			int cnt = 1;
			int level = 0;
			
			while(!queue.isEmpty()) {
				
				
				int[] place = queue.poll();
				int number = map[place[0]][place[1]];
				level = place[2]; 
				
				// 뺀 파이프 확인
				// 1 - 0123 / 2 - 02 / 3- 13 / 4 - 01 / 5 - 12 / 6 - 23 / 7 - 03
				// 연결될 수 있는 파이프
				// 상 - 1256 / 우 - 1367 / 하 - 1247 / 좌 - 1345
				for (int d = 0; d < dCheck[number].length; d++) {
					int nr = place[0] + dr[dCheck[number][d]];
					int nc = place[1] + dc[dCheck[number][d]];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && isAvailable(dCheck[number][d], nr, nc) && level<L) {
						visited[nr][nc] = true;
						cnt++;
						queue.add(new int[] {nr, nc, level+1}); 
					}
				}
				
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		} // tc
		
	} // main
	
	static boolean isAvailable(int prev, int r, int c) {
		if(prev==0) { // 상
			if(map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 5 || map[r][c] == 6) {
				return true;
			}
		} else if(prev==1) { // 우
			if(map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 6 || map[r][c] == 7) {
				return true;
			}
		} else if(prev==2) { // 하
			if(map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 4 || map[r][c] == 7) {
				return true;
			}
		} else if(prev==3) { // 좌
			if(map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 4 || map[r][c] == 5) {
				return true;
			}
		}
		return false;
	}
}
