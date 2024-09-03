import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 1~N 중 M개 고르기 (중복O, 순서O) -> 순열 (visited 빼면됨)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sel = new int[M];
		perm(N, M, sel, 0);
		
		System.out.println(sb);
	}
	
	public static void perm(int N, int M, int[] sel, int sidx) {
		// 기저 조건
		if(sidx==M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		for (int i = 1; i <= N; i++) {
			// 선택O
			sel[sidx] = i;
			perm(N, M, sel, sidx+1);
		}
	}
}
