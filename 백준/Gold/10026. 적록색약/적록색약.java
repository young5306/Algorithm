import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] area;
	static boolean[][] visited;
	static int cnt;
	// 상우하좌
	static int[] dr = {-1,0,1,0}; 
	static int[] dc = {0,1,0,-1}; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				area[i][j] = str.charAt(j);
			}
		} // 입력 완료
		
		// 1. 적록색약 X
		cnt = 0;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					bfs1(r, c);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");
		
		// 2. 적록색약
		cnt = 0;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					bfs2(r, c);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		
		System.out.println(sb);
		
	}
	
	static boolean recogSameColor(char color, char nextColor) {
		switch(color) {
//		case 'R', 'G' : // 컴파일 에러(자바14부터 가능)
		case 'R': case 'G':
			if(nextColor=='R' || nextColor=='G') return true;
			break;
		default :
			if(nextColor=='B') return true;
			break;
		}
		return false;
	}
	
	static void bfs2(int sR, int sC) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sR, sC});
		visited[sR][sC] = true;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			char color = area[r][c];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && recogSameColor(color, area[nr][nc])) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	static void bfs1(int sR, int sC) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sR, sC});
		visited[sR][sC] = true;
		
		while(!q.isEmpty()) {
			int[] place = q.poll();
			int r = place[0];
			int c = place[1];
			char color = area[r][c];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && area[nr][nc]==color) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	

}
