
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		
		public Node() {};
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o){
			if(this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Node[] arr = new Node[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(x, y);
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(Node n : arr) {
			sb.append(n.x).append(" ").append(n.y).append("\n");
		}
		System.out.println(sb);
	}
}
