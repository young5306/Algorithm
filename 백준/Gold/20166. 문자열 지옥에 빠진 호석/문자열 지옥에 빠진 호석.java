

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 좌상부터 반시계
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	static int N, M, strNum, cnt;
	static char[][] map;
	static String[] str;
	static int[] strCnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		strNum = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		str = new String[strNum];
		strCnt = new int[strNum];
		for (int i = 0; i < strNum; i++) {
			str[i] = br.readLine();
		} // 입력 완료
		
		out: for (int i = 0; i < strNum; i++) {
			
			for (int j = i-1; j >=0 ; j--) {
				if(str[i].equals(str[j])) {
					strCnt[i] = strCnt[j];
					continue out;
				}
			}
			
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == str[i].charAt(0)) {
						// dfs 시작
						dfs(r, c, i, 1);
					}
				}
			}
			
			strCnt[i] = cnt;
		}
		
		for(int i : strCnt) {
			System.out.println(i);
		}

	} // main
	
	static void dfs(int r, int c, int i, int idx) { // i : 문자열 번호 // idx : 문자열 내 인덱스
		// 기저 조건
		if(idx == str[i].length()) {
			cnt++;
			return;
		}
		
		// 재귀 부분
		for (int d = 0; d < 8; d++) {
			int nr = (r + dr[d] + N) % N;
			int nc = (c + dc[d] + M) % M;
			
			if(map[nr][nc] == str[i].charAt(idx)) {
				dfs(nr, nc, i, idx + 1);
			}
		}
	}
	
}
