

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 하나로 문제 유사한 듯

	static class Edge implements Comparable<Edge> {
		int s; // 연결된 별 번호
		double w; // 가중치

		public Edge(int s, double w){
			this.s=s;
			this.w=w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w); // 오름차순
		}
	}
	
	static double[][] star;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 전체 연결하는 최소 비용 (최소신장트리mst)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 간선을 저장하자 (가중치 넣어서)
		List<Edge>[] adj = new ArrayList[n];
		star = new double[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			adj[i] = new ArrayList<>();
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		} // 입력 완료

		// 가중치 저장하기
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				// 가중치
				double w = calcW(i,j);
				
				adj[i].add(new Edge(j, w));
				adj[j].add(new Edge(i, w));
				Edge ee = new Edge(j, w);
//				System.out.println(ee.s+","+ee.w);
			}
		}
		
		// mst
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 0 먼저 방문
		pq.addAll(adj[0]);
		
		boolean[] visited= new boolean[n];
		visited[0] = true;
		int pick = 1;
		double sum = 0;
		
		while(pick!=n) {
			Edge e = pq.poll();
			if(visited[e.s]) continue;
			
			pick++;
			visited[e.s] = true;
			sum += e.w;
			
			for(Edge edge : adj[e.s]) {
				if(!visited[edge.s])
					pq.add(edge);
			}
		}
		
		System.out.printf("%.2f", sum);
	}
	
	static double calcW(int i, int j) {
		double w = Math.sqrt(Math.pow(star[i][0]-star[j][0],2)+Math.pow(star[i][1]-star[j][1],2));
		return w;
	}

}
