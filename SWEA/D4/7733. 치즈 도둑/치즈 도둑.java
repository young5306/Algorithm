import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] cheese = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 1;
			for (int day = 0; day <= 100; day++) {
				boolean[][] visited = new boolean[N][N];
				int cnt = 0;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						
						if(cheese[i][j]>day && !visited[i][j]) {
							cnt++;
							Queue<int[]> q = new LinkedList();
							q.add(new int[] {i,j});
							visited[i][j] = true;
							
							while(!q.isEmpty()) {
								int[] place = q.poll();
								int r = place[0];
								int c = place[1];
								
								for (int d = 0; d < 4; d++) {
									int nr = r + dr[d];
									int nc = c + dc[d];
									if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && cheese[nr][nc]>day) {
										q.add(new int[] {nr,nc});
										visited[nr][nc] = true;
									}
								}
							}
							
						}
					} // forj
				} // fori
				max = Math.max(max, cnt);
			} // for day
			
			
			
			System.out.println("#"+tc+" "+max);
		}

	}

}
