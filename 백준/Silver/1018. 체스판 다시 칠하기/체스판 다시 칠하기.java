
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 시작 ridx, cidx
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 시작이 W / B인 경우
		int[][] Wcnt = new int[N][M];
		int[][] Bcnt = new int[N][M];
		boolean rStartColor = true; // white
		
		for (int i = 0; i < N; i++) {
			
			boolean prev = rStartColor;
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				
				if(prev) {
					if(ch == 'W') {
						Bcnt[i][j] = 1;
					} else {
						Wcnt[i][j] = 1;
					}
				} else {
					if(ch == 'W') {
						Wcnt[i][j] = 1;
					} else {
						Bcnt[i][j] = 1;
					}
				}
				prev = !prev;
				
			}
			rStartColor = !rStartColor;
		}
		
//		for(int[] i : Wcnt) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println("===========");
//		for(int[] i : Bcnt) {
//			System.out.println(Arrays.toString(i));
//		}
		
		// rStart, cStart
		int res = Integer.MAX_VALUE;
		for (int rStart = 0; rStart <= N-8; rStart++) {
			for (int cStart = 0; cStart <= M-8; cStart++) {
				
				int wRes = 0;
				int bRes = 0;
				
				for (int i = rStart; i < rStart+8; i++) {
					for (int j = cStart; j < cStart+8; j++) {
						
						wRes += Wcnt[i][j];
						bRes += Bcnt[i][j];
					}
				}
				
				res = Math.min(Math.min(wRes, bRes), res);
			}
		}
		
		System.out.println(res);
	}

}
