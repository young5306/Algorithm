import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 상우하좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		// bfs가 빠를듯
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ir = 0;
		int ic = 0;
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if(ch == 'I') {
					ir = i;
					ic = j;
				} else if(ch == 'X') {
					visited[i][j] = true;
				}
				map[i][j] = ch;
			}
		} // 입력 완료
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {ir, ic});
		visited[ir][ic] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
//			System.out.println(r+","+c);
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					q.add(new int[] {nr, nc});
					if(map[nr][nc]=='P') cnt++;
					visited[nr][nc] = true;
				}
			}
		}
		
		System.out.println(cnt==0 ? "TT" : cnt);
		
		
		
	}

}
