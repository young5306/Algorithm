import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adj;
	static int N, M, V;
	static boolean[] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1]; // 1~N
		
		for (int i =1; i <= N; i++) { 
			adj[i] = new ArrayList<>(); 
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B); // 양방향
			adj[B].add(A);
		}
		for(int i=1; i<=N; i++){ // 리스트를 오름차순으로 해야 작은 수부터 나옴
			Collections.sort(adj[i]);
		} // sort 마음에 안들엉
		
		// DFS 수행 결과
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		// BFS 수행 결과
		visited = new boolean[N+1];
		q = new LinkedList<>();
		bfs(V);
	
	}
	
	static void dfs(int V) { // 인접행렬 코드와 비교
		visited[V] = true;
		System.out.print(V+" ");
		
		for (int i : adj[V]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int V) {
		visited[V] = true;
		q.add(V);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v+" ");
			for (int i : adj[v]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
