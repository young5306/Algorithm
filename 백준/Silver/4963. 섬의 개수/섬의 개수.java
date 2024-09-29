import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 상부터 시계방향
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			int[][] map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[h][w];
			int cnt = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					
					if(map[i][j]==1 && !visited[i][j]) {
						cnt++;
						
						Queue<int[]> q = new LinkedList();
						q.add(new int[]{i, j});
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							int[] place = q.poll();
							int r = place[0];
							int c = place[1];
							
							for (int d = 0; d < 8; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								if(nr>=0 && nr<h && nc>=0 && nc<w && !visited[nr][nc] && map[nr][nc]==1) {
									q.add(new int[] {nr, nc});
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
		
		
	}

}
