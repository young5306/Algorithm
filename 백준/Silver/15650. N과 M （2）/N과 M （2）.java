import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 1~N 중 중복없이 M개 고르기 (순서O) -> 중복X 조합
		// 중복 X - visited 배열 필요
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sel = new int[M];
		boolean[] visited = new boolean[N+1]; // 1~N
		combination(N, M, sel, visited, 1, 0);
	}
	
	public static void combination(int N, int M, int[] sel, boolean[] visited, int idx, int sidx) {
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
//			System.out.println(i);
			// 선택 O
			if(!visited[i]) {
				sel[sidx] = i;
				visited[i] = true;
//				System.out.println("재귀");
				combination(N, M, sel, visited, i+1, sidx+1); // idx+1로 했다가 틀림
				visited[i] = false; // 원상복구
			}
		}
	}
	

}
