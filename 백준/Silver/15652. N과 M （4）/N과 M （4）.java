
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		dfs(1, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sidx) {
		// 기저 조건
		if(sidx >= M) {
			for(int n: num) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		for(int i=idx; i<=N; i++) {
			// 선택o
			num[sidx] = i;
			dfs(i, sidx+1);
			// 선택x
		}
	}

}
