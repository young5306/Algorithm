import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		// N개 중 M개 선택 (중복O, 순서O) -> 중복O 순열 (visited 빼)
		// 사전 순 출력 -> nums 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int[] sel = new int[M];
		perm(N, M, nums, sel, 0);
		
		System.out.println(sb);
	}
	
	public static void perm(int N, int M, int[] nums, int[] sel, int sidx) {
		// 기저 조건
		if(sidx==M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			// 선택O
			sel[sidx] = nums[i];
			perm(N, M, nums, sel, sidx+1);
		}
	}

}
