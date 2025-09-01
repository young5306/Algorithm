
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 0, 1, -1, 0, 0}; // 동서남북상하
	static int[] dc = {1, -1, 0, 0, 0, 0};
	static int[] dl = {0, 0, 0, 0, 1, -1};
	
	static class Square implements Comparable<Square> {
		int r;
		int c;
		int l;
		int t;
		
		Square(){};
		Square(int r, int c, int l, int t){
			this.r = r;
			this.c = c;
			this.l = l;
			this.t = t;
		}
		
		@Override
		public int compareTo(Square o) {
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) { // eof
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0  && C == 0) break;
			
			char[][][] building = new char[R][C][L];
			int sr = 0;
			int sc = 0;
			int sl = 0;
			for(int l = 0; l < L; l++) {
				for(int r = 0; r < R; r++) {
					String str = br.readLine();
					for(int c = 0; c < C; c++) {
						char ch = str.charAt(c);
						building[r][c][l] = ch;
						if(ch == 'S') {
							sr = r;
							sc = c;
							sl = l;
						}
					}
				}
				br.readLine();
			}
//			System.out.println(sr +", " + sc + ", " + sl);

			// bfs
			PriorityQueue<Square> pq = new PriorityQueue<>();
			boolean[][][] visited = new boolean[R][C][L];
			
			pq.add(new Square(sr, sc, sl, 0));
			visited[sr][sc][sl] = true;
			
			int answer = 0;
			
			while(!pq.isEmpty()) {
				Square cur = pq.poll();
				
				for(int d = 0; d < 6; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					int nl = cur.l + dl[d];
					if(nr >= 0 && nc >= 0 && nl >= 0 && nr < R && nc < C && nl < L 
							&& !visited[nr][nc][nl] && building[nr][nc][nl] != '#') {
						// break
						if(building[nr][nc][nl] == 'E') {
							answer = cur.t + 1;
						}
						pq.add(new Square(nr, nc, nl, cur.t + 1));
						visited[nr][nc][nl] = true;
					}
				}
			}
			System.out.println(answer == 0 ? "Trapped!" : "Escaped in " + answer + " minute(s).");
		}
	}
}
