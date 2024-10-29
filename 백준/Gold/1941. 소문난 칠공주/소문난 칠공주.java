
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] stu;
	static boolean[][] selected;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stu = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				stu[i][j] = str.charAt(j);
			}
		} // 입력 완료
		
		// 1. 7명 고르기 (조합)
		selected = new boolean[5][5];
		cnt = 0;
		comb(0,0,0,0); // r, c, sidx, S수
		
		System.out.println(cnt);
	} // main
	
	static void comb(int r, int c, int sidx, int scnt) {
		// 기저 조건
		if(sidx == 7) {
			// S가 4명 이상
			if(scnt<4) {
				return;
			}
			// 인접한지 확인
			if(available()) {
				cnt++;
			}
			return;
		}
		
		if(r==5) return;
		
		// 재귀 부분
		 // 선택O
		selected[r][c] = true;
		if(stu[r][c]=='S') scnt++;
		if(c+1==5) comb(r+1, 0, sidx+1, scnt);
		else comb(r, c+1, sidx+1, scnt);
		if(stu[r][c]=='S') scnt--;
		 // 선택X
		selected[r][c] = false;
		if(c+1==5) comb(r+1, 0, sidx, scnt);
		else comb(r, c+1, sidx, scnt);
	}
	
	static boolean available() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		out : for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(selected[i][j]) {
					q.add(new int[]{i,j});
					visited[i][j] = true;
					break out;
				}
			}
		}
		
		int pick = 1;
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int r = v[0];
			int c = v[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr<5 && nc>=0 && nc<5 && !visited[nr][nc] && selected[nr][nc]) {
					visited[nr][nc] = true;
					pick++;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		if(pick==7) return true;
		else return false;
		
	}

}
