import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// N개의 자연수 중 M개를 고른 수열 (중복X, 순서O) -> 중복X 순열 (visited 배열 필요)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 사전 순 출력하려면 nums 배열 정렬
		boolean[] visited = new boolean[N];
		int[] sel = new int[M];
		
		perm(N, M, nums, sel, visited, 0);
		
		System.out.println(sb); 
	}
	
	// 이렇게 다 들고 다녀..?
	public static void perm(int N, int M, int[] nums, int[] sel, boolean[] visited, int sidx) {
		// 기저 조건
		if(sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			// 선택O
			if(!visited[i]) {
				visited[i] = true;
				sel[sidx] = nums[i];
				perm(N, M, nums, sel, visited, sidx+1);
				visited[i] = false;
			}
		}
	}

}
