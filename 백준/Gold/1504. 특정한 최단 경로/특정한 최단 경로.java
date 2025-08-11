

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Node>[] conn;
	static int N, E;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int a;
		int b;
		int c;
		
		Node(){}
		Node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.c - o.c; // 오름차순
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 거리 저장
		conn = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			conn[i] = new LinkedList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			conn[a].add(new Node(a, b, c));
			conn[b].add(new Node(b, a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 최단 경로 1) 1 -> v1 -> v2 -> N
		// 최단 경로 2) 1 -> v2 -> v1 -> N
//		int s_v1 = dijkstra(1, v1);
//		int v1_v2 = dijkstra(v1, v2);
//		int v2_N = dijkstra(v2, N);
//		
//		int s_v2 = dijkstra(1, v2);
//		int v2_v1 = dijkstra(v2, v1);
//		int v1_N = dijkstra(v1, N);
		
		long path1 = (long) dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long path2 = (long) dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        long ans = Math.min(path1, path2);
        System.out.println(ans >= INF ? -1 : ans);

	}
	
	static int dijkstra(int s, int e) {
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[s] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		
		pq.add(new Node(s, s, 0));
		
		while(!pq.isEmpty()) { // 조건...
			Node n = pq.poll();
			
			if(visited[n.b]) continue;
			visited[n.b] = true;
			
			for(Node next : conn[n.b]) {
				if(visited[next.b]) continue;
				if(dist[n.b] + next.c < dist[next.b]) {
					dist[next.b] = dist[n.b] + next.c;
					pq.add(new Node(n.b, next.b, dist[next.b]));
				}
			}
			
			if(n.b == e) break;
		}
		
		return dist[e];
	}

}
