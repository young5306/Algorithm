
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // DFS, BFS, 유니온 파인드 
	
	static int N, E, cnt;
	static List<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1]; 
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		// dfs로 방문한 곳은 모두 cnt하기
		visited = new boolean[N+1];
		cnt = -1; // 1번 컴퓨터 제외
		dfs(1);
		
		System.out.println(cnt);

	}
	
	static void dfs(int v) {
		visited[v] = true;
		cnt++;
		
		for(int i : adj[v]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}

}
