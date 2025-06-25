
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Tomato {
		int x;
		int y;
		int day;
		
		Tomato() {}
		Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
		Queue<Tomato> q = new LinkedList<>();
		int day = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int status = Integer.parseInt(st.nextToken());
				box[i][j] = status;
				if(status == 1) q.add(new Tomato(i, j , 0));
			}
		}
		
		// bfs
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			day = Math.max(day, t.day);
			
			for(int d=0; d<4; d++) {
				int nx = t.x + dr[d];
				int ny = t.y + dc[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && box[nx][ny] == 0) {
					box[nx][ny] = 1; // visited 배열 필요없어짐
					q.add(new Tomato(nx, ny, t.day+1));
				}
			}
		}
		
		// 안익은 토마토 있는지 확인
		boolean flag = true;
		out: for(int row[] : box) {
			for(int col : row) {
				if(col == 0) {
					flag = false;
					break out;
				}
			}
		}
		
		System.out.print(flag ? day : -1);
	}
}

