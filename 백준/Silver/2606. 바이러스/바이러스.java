import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
			
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		visited = new boolean[N+1];
		cnt = 0;
		visited[1] = true;
		dfs(1);
		
		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		// 기저 조건
		
		// 재귀 부분
		for(int num : adj[start]) {
			if(!visited[num]) {
				visited[num] = true;
				cnt++;
				dfs(num);
			}
		}
		
	}
}
