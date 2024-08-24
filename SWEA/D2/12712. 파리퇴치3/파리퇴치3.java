import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		// 델타배열 더 좋은 방법
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int board[][] = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 좌상우하 // 좌상부터 시계방향
			int[] dr = {0,-1,0,1, -1,-1,1,1};
			int[] dc = {-1,0,1,0, -1,1,1,-1};
			
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					int plusSum = board[r][c];
					int multiSum = board[r][c];
					
					int nr;
					int nc;
					
					// +
					for (int d = 0; d < 4; d++) {
						nr = r + dr[d];
						nc = c + dc[d];
						for (int m = 1; m < M; m++) {
							
							if(nr>=0 && nc>=0 && nr<N && nc<N) {
								plusSum += board[nr][nc];
								nr += dr[d];
								nc += dc[d];
							} else break;
						}
					}
					// x
					for (int d = 4; d < 8; d++) {
						nr = r + dr[d];
						nc = c + dc[d];
						for (int m = 1; m < M; m++) {
							if(nr>=0 && nc>=0 && nr<N && nc<N) {
								multiSum += board[nr][nc];
								nr += dr[d];
								nc += dc[d];
							} else break;
						}
					}
					
					max = Math.max(max, Math.max(plusSum, multiSum));
				}
			}
			System.out.println("#"+test_case+" "+max);
		}

	}
}

