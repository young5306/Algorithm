

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge> {
		int B;
		double W;
		public Edge(int b, double w) {
			super();
			B = b;
			W = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}
	}

	public static void main(String[] args) throws Exception {
		
		// 최소 비용으로 모든 점 연결
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 1. 입력 받기 : 각 좌표에 0~N-1번 부여, Edge(B,W) 입력
			int[][] land= new int[N][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				land[i][0] = Integer.parseInt(st.nextToken()); // x좌표
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				land[i][1] = Integer.parseInt(st.nextToken()); // y좌표
			}
			double E = Double.parseDouble(br.readLine());
			// 입력 완료
			List<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int x1 = land[i][0];
					int y1 = land[i][1];
					int x2 = land[j][0];
					int y2 = land[j][1];
					
					double w = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
					adj[i].add(new Edge(j,w));
					adj[j].add(new Edge(i,w)); // 무향
				}
			} // 간선 저장 완료
			
			// 0번 점에서 시작
			boolean[] visited = new boolean[N];
			visited[0] = true;
			// pq에 연결간선 담기
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adj[0]);
			
			double ans = 0;
			int pick = 1;
			while(pick!=N) {
				Edge e = pq.poll();
				if(visited[e.B]) continue;
				
				ans += Math.pow(e.W,2);
				pick++;
				visited[e.B] = true;
				
				pq.addAll(adj[e.B]);
			}
			
			System.out.println("#"+tc+" "+Math.round(ans*E));
		}
	}

}
