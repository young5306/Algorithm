import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 1~N 중 중복없이 M개 고른 수열 모두 구해서 출력
		// 중복 X 순열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sel = new int[M];
		boolean[] visited = new boolean[N+1];
		combination(N, M, sel, visited, 0);

	}
	
	// 순열은 sidx만 필요 (조합은 idx도 필요)
	public static void combination(int N, int M, int[] sel, boolean[] visited, int sidx) {
		// 기저 조건
		if(sidx==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 부분
		for (int i = 1; i <= N; i++) { // 순서 있음
			// 선택 O
			if(!visited[i]) {
				sel[sidx] = i;
				visited[i] = true;
				combination(N, M, sel, visited, sidx+1);
				visited[i]=false; // 원상복구
			}
		}
	}
}
