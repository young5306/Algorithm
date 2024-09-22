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
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Node>[] adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Node(B, W));
		} 
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 1. 입력 완료
		
		// 2. dist, visited 배열
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N+1];
		
		// 3. 시작점 pq에 넣기
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		// 4. 반복
		while(!visited[end]) {
			Node curr = pq.poll();
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			
			for(Node node : adj[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v]+node.w) {
					dist[node.v] = dist[curr.v]+node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
		System.out.println(dist[end]);

	}

}
