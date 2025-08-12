
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		Node(){}
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<Integer>[] conn = new LinkedList[N + 1];
		for(int i = 1; i <= N; i++) {
			conn[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			conn[a].add(b);
		}
		
		// dijk
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 1000000);
		
		pq.add(new Node(X, 0));
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
//			System.out.println(cur.v);
			visited[cur.v] = true;
			
			for(int n : conn[cur.v]) {
//				System.out.println(n);
				if(!visited[n] && dist[n] > dist[cur.v] + 1) {
					dist[n] = dist[cur.v] + 1;
					pq.add(new Node(n, dist[n]));
				}
			}
		}
		
//		System.out.println(Arrays.toString(dist));
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		
		if(!flag) System.out.println(-1);
	}
}
