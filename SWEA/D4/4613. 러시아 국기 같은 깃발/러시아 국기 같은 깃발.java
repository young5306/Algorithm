import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[N][M];
			
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < M; c++) {
					board[r][c] = str.charAt(c);
				}
			}
			
			// 각 라인별로 바꿔야하는 횟수
			int[] cntW = new int[N];
			int[] cntB = new int[N];
			int[] cntR = new int[N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(board[r][c] == 'W') {
						cntB[r]++;
						cntR[r]++;
					} else if (board[r][c] == 'B') {
						cntW[r]++;
						cntR[r]++;
					} else {
						cntW[r]++;
						cntB[r]++;
					}
				}
			}
			
			int startB=0; // B시작
			int startR=0; // R시작
			
			int min = 2500; // 50*50
			for (startB = 1; startB < N-1; startB++) {
				for (startR = startB+1; startR < N; startR++) {
					int sum = 0;
					for (int r = 0; r < startB; r++) {
						sum += cntW[r];
					}
					for (int r = startB; r < startR; r++) {
						sum += cntB[r];
					}
					for (int r = startR; r < N; r++) {
						sum += cntR[r];
					}
					
					min = Math.min(min, sum);
				}
			}
			
			System.out.println("#"+test_case+" "+min);
		}
		
	}

}
