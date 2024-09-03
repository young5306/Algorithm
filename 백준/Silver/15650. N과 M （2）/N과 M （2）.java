import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM2 {

	public static void main(String[] args) throws Exception {
		// 1~N 중 중복없이 M개 고르기 (순서X) -> 중복X 조합 (조합은 visited 필요X)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sel = new int[M];
		combination(N, M, sel, 1, 0);
	}
	
	public static void combination(int N, int M, int[] sel, int idx, int sidx) {
		// 기저 조건
		if(sidx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		// 재귀 부분
		for (int i = idx; i <= N; i++) {
			// 선택 O
			sel[sidx] = i;
			combination(N, M, sel, i+1, sidx+1); // idx+1로 했다가 틀림
		}
	}
}
