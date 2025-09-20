
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			for(int r = x1; r <= x2; r++) {
				for(int c = y1; c <= y2; c++) {
					board[r][c] = -1;
				}
			}
		}
		
//		boolean[][] visited = new boolean[M][N];
		List<Integer> list = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(board[r][c] == -1) continue;
				// bfs
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {r, c});
				board[r][c] = -1;
				int cnt = 0;
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					cnt++;
					
					for(int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= 0 && nc >= 0 && nr < N && nc < M && board[nr][nc] != -1) {
							q.add(new int[] {nr, nc});
							board[nr][nc] = -1;
						}
					}
				}
				
				list.add(cnt);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int l : list) {
			System.out.print(l + " ");
		}
	}

}
