
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt;
	static List<Integer>[] adj;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception { // DFS, BFS, 유니온 파인드 가능
		
		// 치즈도둑, 유기농 배추와 유사
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// dfs
		visited = new boolean[N+1];
		cnt = 0;
		
		q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	
	static void bfs(int v) {
		visited[v] = true;
		q.add(v);
		
		while(!q.isEmpty()) {
			int n = q.poll();
			for (int i : adj[n]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
	}

}