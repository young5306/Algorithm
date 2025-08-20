
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	static int N;
	static boolean[] visited;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		selected = new int[N];
		
		dfs(0); 
	}
	
	static void dfs(int sidx) {
		// 기저 조건
		if(sidx == N) {
			for(int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		// 재귀 부분
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			selected[sidx] = i;
			visited[i] = true;
			dfs(sidx + 1); 
			visited[i] = false;
		}
	}

}
