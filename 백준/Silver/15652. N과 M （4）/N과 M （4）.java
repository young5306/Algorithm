import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 1~N 중 M개 고르기 (중복O, 순서X) -> 조합 (변경사항 : i+1 -> i)
		// 비내림차순 = 오름차순 + 인접한 두 수가 같아도 됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sel = new int[M];
		combination(N, M, sel, 1, 0);
		
		System.out.println(sb);
	}
	
	public static void combination(int N, int M, int[] sel, int idx, int sidx) {
		// 기저 조건
		if(sidx==M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀 부분
		for (int i = idx; i <= N; i++) {
			sel[sidx] = i;
			combination(N, M, sel, i, sidx+1);
		}
	}
}
