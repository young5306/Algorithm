
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0}); // x, y, 벽 부순 여부
		int[][][] visited = new int[2][N][M]; // 0 벽 안부숨, 1 벽 부순 적 있음
		visited[0][0][0] = 1; // 최단 경로 값
		
		int path = 0;
		out: while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N - 1 && cur[1] == M - 1) {
				System.out.println(visited[cur[2]][cur[0]][cur[1]]);
                return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == 0) { // 벽
					if(visited[cur[2]][nr][nc] == 0) { // 방문 한 적 x
						visited[cur[2]][nr][nc] = visited[cur[2]][cur[0]][cur[1]] + 1;
						q.add(new int[] {nr, nc, cur[2]});
					}
				}
				else { // 벽
					if(cur[2] == 0 && visited[1][nr][nc] == 0) { // 벽 부순 적 없고, 해당 위치에 벽부수고 방문한 적 없는 경우
						visited[1][nr][nc] = visited[cur[2]][cur[0]][cur[1]] + 1;
						q.add(new int[] {nr, nc, 1});
					}
				}
			}
		} // while
		System.out.println(-1);
	}
}
