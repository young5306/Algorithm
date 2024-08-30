

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] box;
	static int[][] tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 세로100, 가로N
			
			// 오리지널 박스
			box = new int[100][N]; //0~99, 0~N-1
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int boxPerLine = Integer.parseInt(st.nextToken());
				
				for (int j = 99; j > 99-boxPerLine ; j--) {
					box[j][i] = 1;
				}
			}
//			for (int i = 0; i < 100; i++) {
//				System.out.println(Arrays.toString(box[i]));
//			}
			
			// 회전시키기 (시계90도)
			tmp = new int[N][100];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < 100; c++) {
					tmp[r][c] = box[99-c][r];
				}
			}
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(tmp[i]));
//			}
			
			// 중력 반영 - 충돌하면 같이 떨어지게
			// 세로N, 가로100 상태
			int maxDrop = 0; // 최대 낙차
			for (int c = 0; c < 100; c++) { // 열에서 제일 위에 있는 박스 찾기
				
				int top = -1; // 중력으로 내려오는 박스의 top 인덱스
				int bottom = -1; // 중력으로 내려오는 박스의 bottom 인덱스
				
				for (int r = 0; r < N; r++) {					
					if(tmp[r][c]==1) {
						top = r;
						bottom = r;
						break;
					}
				}
				if(top==-1) continue;
				int first = top; // 첫박스의 처음 위치
				
				// 열별 첫 박스 위치 (r,c)
				while(bottom<N-1) {
					// 박스 더미일 경우 bottom만 늘림
					if(tmp[bottom+1][c] == 1) {
						bottom++;
					}
					// 이동하는 경우 - top, bottom+1을 swap
					else {
						swap(c, top, bottom+1);
						top++;
						bottom++;
					}
				}
				
				int drop = top-first;
				maxDrop = Math.max(maxDrop, drop);
				
			}
//			
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(tmp[i]));
//			}
			
			System.out.println("#"+t+" "+maxDrop);
			
		} // for tc
	} // main
	
	static void swap(int c, int top, int move) {
		int temp = tmp[top][c];
		tmp[top][c] = tmp[move][c];
		tmp[move][c] = temp;
	}
}
