
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int w;
		
		Node(){}
		Node(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] miro = new int[M + 1][N + 1];
		for(int r = 1; r <= M; r++) {
			String str = br.readLine();
			for(int c = 1; c <= N; c++) {
				miro[r][c] = str.charAt(c - 1) - '0';
			}
		}
		
		// 각 칸 dijk
		int[][] dist = new int[M + 1][N + 1];
		for(int[] d : dist) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 1, 0));
		dist[1][1] = 0;
		boolean[][] visited = new boolean[M + 1][N + 1];
		
		while(!visited[M][N]) {
			Node cur = pq.poll();
			visited[cur.r][cur.c] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= 1 && nr <= M && nc >= 1 && nc <= N && !visited[nr][nc]) {
					if(dist[nr][nc] > cur.w + miro[nr][nc]) {
						dist[nr][nc] = cur.w + miro[nr][nc];
						visited[nr][nc] = true;
						pq.add(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		
		System.out.println(dist[M][N]);
	}

}
