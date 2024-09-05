import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		// 순서 없음 - 조합
		// 중복 선택 가능 - 본인 포함 재귀
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		N = set.size();
		int[] nums = new int[N];
		int idx = 0;
		for(int i : set) {
			nums[idx++] = i;
		}
		int[] sel = new int[M];
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
		for (int i = idx; i < N; i++) {
			sel[sidx] = nums[i];
			combination(N, M, nums, sel, i, sidx+1);
		}
	}

}
