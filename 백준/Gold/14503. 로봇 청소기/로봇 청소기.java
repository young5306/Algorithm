import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0}; // 북동남서 
	static int[] dc = {0, 1, 0, -1};
	static int N, M, r, c, d;
	static int[][] room;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 북0 동1 남2 서3
		
		room = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println("시작: "+r+", "+c);
		int cnt = 0;
		
		while(true) {
			// 1. 현재칸 청소
//			System.out.println("("+r+", "+c+") d="+d);
			if(room[r][c] == 0) {
				cnt++;
				room[r][c] = -1;
			}
			
			// 2. 주변칸 확인
			if(!allCleaned()) {
				d = (d+3) % 4;
				if(room[r + dr[d]][c + dc[d]] == 0) {
					r += dr[d];
					c += dc[d];
				}
			} else {
				if(room[r - dr[d]][c - dc[d]] != 1) {
					r -= dr[d];
					c -= dc[d];
				}
			}
			
			if(stop()) break;
		}
		
		System.out.println(cnt);
	}
	
	static boolean stop() {
		// 주변 4칸 모두 청소되어 있고
		// 뒤쪽 칸이 벽인 경우 작동 멈춤
		if(allCleaned() && room[r - dr[d]][c - dc[d]] == 1) {
			return true;
		}
		return false;
	}
	
	static boolean allCleaned() {
		boolean cleaned = true;
		for(int i=0; i<4; i++) {
			if(room[r + dr[i]][c + dc[i]] == 0) {
				cleaned = false;
				break;
			}
		}
		return cleaned;
	}

}
