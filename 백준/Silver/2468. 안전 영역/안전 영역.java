import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static int[][] area;
	static int N;
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 치즈도둑이자나
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		area = new int[N][N];
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				area[i][j] = num;
				maxHeight = Math.max(maxHeight, num);
				
			}
		} // 입력 완료
		
		
		// 비의 양(1~최대지점높이maxHeight) 전부 탐색해야 함
		// 100번 * (N*N) = 10^6 => 1초(10^9) 안에 가능
		int maxSafe = 1; // 0일때는 1
		for (int h = 1; h <= maxHeight; h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					//bfs
					if(!visited[r][c] && area[r][c] > h) {
						bfs(r, c, h);
						cnt++;
					}
				}
			}
			
			maxSafe = Math.max(maxSafe, cnt);
		}
		
		System.out.println(maxSafe);

	} // main

	static void bfs(int startR, int startC, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && area[nr][nc]>h) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		
	}

}
