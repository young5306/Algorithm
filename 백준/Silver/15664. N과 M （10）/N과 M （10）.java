import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		// N개 중 M개 고름
		// 중복 입력 가능, 사전 순 출력 -> nums 정렬한 후 조합
		// 중복X, 순서X -> 중복X 조합
		// 중복 입력 가능 - before 사용
		
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
		
		int[] sel = new int[N];
		combination(N, M, nums, sel, 0, 0);
		
		System.out.println(sb);
	}
	
	public static void combination(int N, int M, int[] nums, int[] sel, int idx, int sidx) {
		// 기저 조건
		if(sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀 부분
		int before = 0;
		for (int i = idx; i < N; i++) {
			if(before != nums[i]) {
				before = nums[i];
				sel[sidx] = nums[i];
				combination(N, M, nums, sel, i+1, sidx+1);
			}
		}
	}

}
