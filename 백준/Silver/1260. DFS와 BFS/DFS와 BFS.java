
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[N + 1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		sb = new StringBuilder();
		// dfs
		visited = new boolean[N + 1];
		visited[V] = true;
		dfs(V);
		sb.append("\n");
		
		// bfs
		bfs(V);
		
		System.out.println(sb);
	}
	
	static void dfs(int V) {
		
		// 재귀 부분
		sb.append(V).append(" ");
		Collections.sort(adj[V]);
		for(int a : adj[V]) {
			if(visited[a]) continue;
			visited[a] = true;
			dfs(a);
		}
	}
	
	static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];
		q.add(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			Collections.sort(adj[cur]);
			for(int a : adj[cur]) {
				if(visited[a]) continue;
				visited[a] = true;
				q.add(a);
			}
		}
	}

}
