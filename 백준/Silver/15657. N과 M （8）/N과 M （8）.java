
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] num;
	static int[] sel;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		sel = new int[M];
		dfs(0, 0);

		System.out.println(sb);
	}
	
	static void dfs(int idx, int sidx) {
		// 기저 조건
		if(sidx >= M) {
			for(int s: sel) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		for(int i=idx; i<N; i++) {
			sel[sidx] = num[i];
			dfs(i, sidx+1);
		}
	}
}  
