
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge>[] adj = new ArrayList[V+1]; // 1~V
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		} // 입력 완료
		
		boolean[] visited = new boolean[V+1];
		// 1. 시작점 선택
		visited[1] = true;
		// 2. 연결간선 pq에 넣어
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adj[1]);
		
		int ans = 0;
		int pick = 1;
		while(pick != V) {
			Edge e = pq.poll(); // 3. 가중치 작은거 빼
			if(visited[e.B]) continue;
			
			visited[e.B] = true;
			ans += e.C;
			pick++;
			
			pq.addAll(adj[e.B]);
		}
		
		// 최소 가중치 출력
		System.out.println(ans);
	}

}
