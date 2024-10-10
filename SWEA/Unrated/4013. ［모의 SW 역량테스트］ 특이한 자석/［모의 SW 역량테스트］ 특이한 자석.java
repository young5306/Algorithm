
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] redIdx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int[][] mags = new int[5][8]; // 1~4
			redIdx = new int[5]; // 빨간색 자성의 idx 변화 저장 (0으로 초기화)
			
			for (int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mags[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int magNum = Integer.parseInt(st.nextToken()); // 자석번호(1~4)
				int dir = Integer.parseInt(st.nextToken()); // 회전방향(시계1, 반시계-1)
				// 1. 입력 완료
				
				// 2. 회전시킬 자석 번호를 list에 저장
				ArrayList<int[]> list = new ArrayList<>(); // 자석번호, 회전방향
				list.add(new int[] {magNum, dir});
				
				// 2-1. 회전하는 자석의 오른쪽 자석들 확인
				int flag = dir;
				for (int i = magNum; i < 4; i++) {
					if(mags[i][rightIdx(i)] != mags[i+1][leftIdx(i+1)]) {
						flag = -flag;
						list.add(new int[] {i+1, flag});
					} else {
						break;
					}
				}
				// 2-2. 회전하는 자석의 왼쪽 자석들 확인
				flag = dir;
				for (int i = magNum; i > 1; i--) {
					if(mags[i][leftIdx(i)] != mags[i-1][rightIdx(i-1)]) {
						flag = -flag;
						list.add(new int[] {i-1, flag});
					} else {
						break;
					}
				}
				// 3. 회전시키기
				for (int[] mag : list) {
					int m = mag[0];
					int d = mag[1];
					// 시계방향이면 redIdx를 - 1
					if(d==1) {
						redIdx[m] = (redIdx[m]+7)%8;
					} 
					// 반시계방향이면 redIdx를 + 1
					else {
						redIdx[m] = (redIdx[m]+1)%8;
					}
				}
				
			} // for K
			
			int result = 0;
			for (int i = 1; i <= 4; i++) {
				if(mags[i][redIdx[i]] == 1) result += Math.pow(2, i-1);
			}
			
			System.out.println("#"+tc+" "+result);
		} // for tc
	}// for main

	static int rightIdx(int n) { // 자석번호
		return (redIdx[n]+2)%8;
	}
	static int leftIdx(int n) {
		return (redIdx[n]+6)%8;
	}

}
