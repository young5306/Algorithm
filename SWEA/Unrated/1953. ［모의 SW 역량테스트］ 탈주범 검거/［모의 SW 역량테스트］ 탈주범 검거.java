import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 세로
			int M = Integer.parseInt(st.nextToken()); // 가로
			int R = Integer.parseInt(st.nextToken()); // 첫위치R
			int C = Integer.parseInt(st.nextToken()); // 첫위치 C
			int L = Integer.parseInt(st.nextToken()); // 소요시간
			
			int[][] tunnel = new int[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					tunnel[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// bfs
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			q.add(new int[]{R, C});
			visited[R][C] = true;
//			System.out.println("RC"+R+","+C);
			int time = 1;
			int cnt = 1;
			
			while(!q.isEmpty()) {
				
				if(time==L) break;
				
				// bfs에서 level 구하기!
				int qSize = q.size();
				for (int qs = 0; qs < qSize; qs++) {
					
					int[] place = q.poll();
					int r = place[0];
					int c = place[1];
//					System.out.println("poll "+r+","+c);
					
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						// 방문한 적 없고, 이동 가능한 곳
						if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && isAvailable(tunnel[r][c], i, tunnel[nr][nc])) {
//							System.out.println(nr+","+nc);
							q.add(new int[] {nr,nc});
							visited[nr][nc] = true;
							cnt++;
						}
					}
				} // for qSize
				time++;
				
			} // while
			
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	static boolean isAvailable(int curr, int dir, int next) {
		// 1. 0이면 바로 false
		if(next==0) return false;
		
		// 2. 이동가능한지
		// curr
		// 상으로 이동가능 : 1247
		// 하로 이동가능  : 1256
		// 우로 이동가능  : 1345
		// 좌으로 이동가능 : 1367 
		int[][] currArr = {{1,2,4,7},{1,3,4,5},{1,2,5,6},{1,3,6,7}};
		// next
		// 상과 연결 : 1256
		// 하와 연결 : 1247
		// 우와 연결 : 1367
		// 좌과 연결 : 1345
		int[][] nextArr = {{1,2,5,6},{1,3,6,7},{1,2,4,7},{1,3,4,5}};
		
		for (int i = 0; i < 4; i++) {
			if(curr == currArr[dir][i]) {
				for (int j = 0; j < 4; j++) {
					if(next == nextArr[dir][j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
