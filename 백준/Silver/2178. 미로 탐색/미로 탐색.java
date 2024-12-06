
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	//상우하좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// bfs
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] {0,0,1}); // r,c,level
		visited[0][0] = true;
		
		int level = 0;
		
		while(!q.isEmpty()){
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			level = place[2];
			
			if(r==N-1 && c==M-1) break;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]!=0) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc, level+1});
				}
			}
		}
		
		System.out.println(level);
		
	}

}
