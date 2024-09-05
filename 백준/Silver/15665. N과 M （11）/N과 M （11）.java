import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		// 여러 번 사용 가능 - 0부터
		// 순서O - 순열
		// 중복O - visited X
		
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
		perm(N, M, nums, sel, 0);
		
		System.out.println(sb);

	}
	
	public static void perm(int N, int M, int[] nums, int[] sel, int sidx) {
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
			sel[sidx] = nums[i];
			perm(N, M, nums, sel, sidx+1);
		}
	}

}
