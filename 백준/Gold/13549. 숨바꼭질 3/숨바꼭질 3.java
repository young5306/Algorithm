
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int location;
		int depth;
		
		Node(){}
		Node(int location, int depth) {
			this.location = location;
			this.depth = depth;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.depth - o.depth;
		}
	}

	public static void main(String[] args) throws Exception {
		// dijk말고  bfs로 푸는게 나을 것 같은데...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 레벨(초)이 있는 bfs
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[100001];
		q.add(new Node(N, 0));
		
		int time = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int l = node.location;
			int d = node.depth;
			visited[l] = true;
//			System.out.println("poll"+ l + ", " + d);
			
			if(l == K) {
				time = d;
				break;
			}
			
			if(l - 1 >= 0 && !visited[l - 1]) {
				q.add(new Node(l - 1, d + 1));
			}
			if(l + 1 <= 100000 && !visited[l + 1]) {
				q.add(new Node(l + 1, d + 1));
			}
			if(2 * l <= 100000 && !visited[2 * l]) {
				q.add(new Node(2 * l, d));
			}
		}
		
		System.out.println(time);
	}
}
