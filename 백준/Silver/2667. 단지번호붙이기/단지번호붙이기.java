
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// bfs 
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		
		int cnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int cntEach = 0;
				
				if(map[i][j]==1 && !visited[i][j]) {
					q.add(new int[] {i, j});
					visited[i][j] = true;
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] place = q.poll();
					cntEach++;
					int r = place[0];
					int c = place[1];
					
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) {
							q.add(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
				
				if(cntEach != 0) pq.add(cntEach);
			}
		}
		
		
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
