

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		Node(){}
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int N;
	static List<Node>[] conn;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 특정점에서 점까지 최단경로 - 다익스트라
		conn = new LinkedList[N + 1];
		for(int i = 1; i <= N; i++) {
			conn[i] = new LinkedList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			conn[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// n -> X -> n
		int max = 0;
		
		// X -> 모든 점으로 최단 경로 저장
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		boolean[] visited = new boolean[N + 1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visited[cur.v] = true;
			
			for(Node node : conn[cur.v]) {
				if(!visited[node.v] && dist[node.v] > dist[cur.v] + node.w) {
					dist[node.v] = dist[cur.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dijkstra(i, X) + dist[i]);
		}
		
		System.out.println(max);
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		boolean[] visited = new boolean[N + 1];
		
		while(!visited[end]) {
			Node cur = pq.poll();
			visited[cur.v] = true;
			
			for(Node node : conn[cur.v]) {
				if(!visited[node.v] && dist[node.v] > dist[cur.v] + node.w) {
					dist[node.v] = dist[cur.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
		return dist[end];
	}

}
