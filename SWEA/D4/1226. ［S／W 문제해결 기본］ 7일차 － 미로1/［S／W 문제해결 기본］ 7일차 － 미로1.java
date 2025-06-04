
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		for(int t=1; t<=10; t++) {
			int tc = Integer.parseInt(br.readLine());
			map = new int[16][16];
			
			String str = "";
			for(int i=0; i<16; i++) {
				str = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// dfs
			int result = dfs(1,1);
			
			System.out.println("#"+tc+" "+result);
		}
		
		
	}

	static int dfs(int r, int c) {
		// 기저 조건
		if(map[r][c] == 3) {
			return 1;
		}
		map[r][c] = 1;
		
		// 재귀 부분
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<16 && nc>=0 && nc<16 && map[nr][nc] != 1) {
				map[r][c] = 1; // 벽으로 바꿈
				if(dfs(nr, nc) == 1) return 1;
			}
		}
		return 0;
	}
}
