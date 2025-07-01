
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
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
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}
		
		// 1부터 시작
		boolean[] visited = new boolean[V+1];
		int dist = 0;
		int pick = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(pick != V) {
			Node cur = pq.poll();
			if(visited[cur.v]) continue;
			
			pick++;
			dist += cur.w;
			visited[cur.v] = true;
			
			for(Node nextNode: adj[cur.v]) {
				if(!visited[nextNode.v]) {
					pq.add(nextNode);
				}
			}
			
		}
		
		System.out.println(dist);
	}

}
