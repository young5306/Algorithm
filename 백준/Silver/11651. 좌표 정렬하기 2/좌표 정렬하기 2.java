

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	//comparable 연습
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		
		Node(){};
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			if(this.y != o.y) return this.y - o.y;
			else return this.x - o.x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(x, y));
		}
		
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			sb.append(node.x).append(" "). append(node.y).append("\n");
		}
		
		System.out.println(sb);
	}
}
