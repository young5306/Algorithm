import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 중복X, 순서O -> 순열
		// 입력값이 중복
		// 정렬한 후 이전에 선택했던 값이랑 똑같으면 넘어가기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int[] sel = new int[M];
		boolean[] visited = new boolean[N];
		
		perm(nums, sel, visited, N, M, 0); 
		
		System.out.println(sb);
	}
	
	public static void perm(int[] nums, int[] sel, boolean[] visited, int N, int M, int sidx) {
		// 기저 조건
		if(sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분 - 같은 자리(sidx)에 같은 수가 안나오게
		// 연이어 중복 수 나올 때 첫 수만 선택되고 중복으로 들어온 다음 수는 선택 안되게
		int before = 0; // N범위에 0없어서 첫수는 항상 선택됨 
		for (int i = 0; i < N; i++) {
			if(!visited[i] && before!=nums[i]) {
				visited[i] = true;
				sel[sidx] = nums[i];
				before = sel[sidx];
				perm(nums, sel, visited, N, M, sidx+1); // 선택O의 경우 36번줄로 가서 before=0됨.
				visited[i] = false;
				// 선택X의 경우, 49번줄로 가서 before=sel[sidx]상태. 
				// sidx자리에 nums[i+1]번 들어오는데, 
				// 이전과 같은 수라면 들어오지 못하고, i+2로 넘어가게
			}
		}
	}
}
