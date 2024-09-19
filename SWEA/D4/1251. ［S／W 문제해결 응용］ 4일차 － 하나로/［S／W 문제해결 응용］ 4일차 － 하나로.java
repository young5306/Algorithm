import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int A;
		int B;
		double W;
		public Edge(int a, int b, double w) {
			super();
			A = a;
			B = b;
			W = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] place = new int[N][2];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					place[j][i] = Integer.parseInt(st.nextToken());
				}
			} 
			double E = Double.parseDouble(br.readLine());
			// 입력 완료
			
			List<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					// 거리
					double distance = Math.sqrt(Math.pow(place[i][0]-place[j][0], 2) + Math.pow(place[i][1]-place[j][1], 2));
					adj[i].add(new Edge(i, j, distance));
					adj[j].add(new Edge(j, i, distance));
				}
			} // 인접리스트 저장 완료
			
			// 프림
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adj[0]); // 0번부터 시작
			boolean[] visited = new boolean[N];
			visited[0] = true;
			
			int pick = 1;
			double ans = 0;
			
			while(pick != N) {
				Edge e = pq.poll();
				
				if(visited[e.B]) continue;
				
				pick++;
				ans += Math.pow(e.W, 2) * E;
				
				visited[e.B] = true;
				pq.addAll(adj[e.B]);
			}
			
			System.out.printf("#%d %.0f\n", tc, ans);
			
		}

	}

}
