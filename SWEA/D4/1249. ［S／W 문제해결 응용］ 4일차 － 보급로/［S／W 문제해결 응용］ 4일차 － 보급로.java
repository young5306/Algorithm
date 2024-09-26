import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node implements Comparable<Node> {
		int r, c, w;

		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Solution.Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 거리 고려 X, 복구 작업 시간만 고려 (0을로 복구)
		// 좌상단(S) -> 우하단(G)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] road = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					road[r][c] = str.charAt(c) - '0';
				}
			}
			
			// 시작(0,0) -> 끝(N-1,N-1)
			// 다익스트라
			// 갱신할 dist 배열 필요
			int[][] dist = new int[N][N];
			int INF = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			boolean[][] visited = new boolean[N][N];
			
			// 1. pq에 시작점 넣기
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0,0));
			dist[0][0] = 0;
			
			while(true) {
				Node n = pq.poll();
				int r = n.r;
				int c = n.c;
				if(n.r==N-1 && n.c==N-1) {
					break;
				}
				visited[r][c] = true;
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 방문한 적 없고, 갱신 가능
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && dist[nr][nc]>dist[r][c]+road[nr][nc]) {
						dist[nr][nc] = dist[r][c]+road[nr][nc];
						pq.add(new Node(nr, nc, dist[nr][nc]));
					}
				}
				
			}
			
			
			System.out.println("#"+tc+" "+dist[N-1][N-1]);
		}

	}

}
