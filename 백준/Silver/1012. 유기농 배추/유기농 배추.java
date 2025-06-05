import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] farm;
	static boolean[][] visited;
	static int cnt, M, N;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		// 0은 벽
		// 1있는곳 bfs/dfs 이동가능
		// 덩어리 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			farm = new int[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[x][y] = 1;
			}
			
			// bfs
			cnt = 0;
			visited = new boolean[M][N];
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c] && farm[r][c] == 1) {
						bfs(r,c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		} // for
	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && farm[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr,nc});
				}
			}
		}
	}
	
	
}
