
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static char[][] board;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) board[i][j] = ' ';
        }
		
		draw(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void draw(int r, int c, int n) {
		// 기저 조건
		if(n == 1) {
			board[r][c] = '*';
			return;
		}
		
		// 재귀 부분
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				draw(r + i * (n / 3), c + j * (n / 3), n / 3);
			}
		}
	}
}
