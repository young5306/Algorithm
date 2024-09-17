import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int B;
		int C;
		public Edge(int b, int c) {
			super();
			B = b;
			C = c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.C - o.C;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Edge>[] adj = new ArrayList[N+1]; // 1~N
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		}
		boolean visited[] = new boolean[N+1];
		visited[1] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : adj[1]) {
			pq.add(e);
		}
		int pick = 1;
		int ans = 0;
		while(pick != N) {
			Edge e = pq.poll();
			if(visited[e.B]) continue;
			
			pick++;
			ans += e.C;
			visited[e.B] = true;
			
			pq.addAll(adj[e.B]);
		}
		
		System.out.println(ans);
	}

}
