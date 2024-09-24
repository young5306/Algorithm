
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1) q.add(new int[]{i,j});
			}
		}
		
		int day = -1;
		
		while(!q.isEmpty()) {
			day++;
			int qSize = q.size();
			for (int s = 0; s < qSize; s++) {
				int[] place = q.poll();
				int r = place[0];
				int c = place[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr>=0 && nr<N && nc>=0 && nc<M && box[nr][nc]==0) {
						box[nr][nc] = 1;
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					flag = false; 
					break;
				}
			}
		}
		
		System.out.println(flag ? day : -1);
		
		
		
	}

}
