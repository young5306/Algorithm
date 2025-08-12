
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		
		List<Node>[] conn = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			conn[i] = new LinkedList<>();
		}
		
		long total = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			conn[a].add(new Node(b, c));
			conn[b].add(new Node(a, c));
			total += c;
		}
		
		// 프림 - 1번 도시부터 시작
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		boolean[] visited = new boolean[N + 1];
		int pick = 0;
		long answer = 0;
		
		while(pick != N && !pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.v]) continue;
			
			visited[cur.v] = true;
			pick++;
			answer += cur.w;
			
			for(Node node : conn[cur.v]) {
				if(visited[node.v]) continue;
				pq.add(node);
			}
		}
		
		System.out.println(pick != N ? -1 : total - answer);
		
	}

}
