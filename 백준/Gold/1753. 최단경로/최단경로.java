
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int v;
		int w;
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()); // 시작점
		List<Node>[] adj = new ArrayList[V+1]; // 1~V 
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			adj[A].add(new Node(B, W));
		} // 1. 입력 완료
		// 2. dist, visited 배열
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[V+1];
		// 3. 시작점부터 pq에 넣기
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));
		dist[K] = 0;
		// 4. 반복 비교
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			
			for(Node node : adj[curr.v]) {
				int transit = dist[curr.v]+node.w;
				if(!visited[node.v] && dist[node.v] > transit) {
					dist[node.v] = transit;
					pq.add(new Node(node.v, transit));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i]!=INF ? dist[i] : "INF");
		}
	}

}
