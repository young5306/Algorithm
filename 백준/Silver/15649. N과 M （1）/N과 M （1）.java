import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] num;
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws Exception {
		
		// 중복없이 N중M 고르기 (순서x)
		// dfs
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		visited = new boolean[N+1];
		dfs(0);
		
	}
	
	static void dfs(int sidx) {
		// 기저 조건
		if(sidx >= M) {
			for(int n: num) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 부분
		for(int i=1; i<=N; i++) {
			// 선택o
			if(visited[i]) continue;
			visited[i] = true;
			num[sidx] = i;
			dfs(sidx+1);
			// 선택x
			visited[i] = false;
		}
	}

}
