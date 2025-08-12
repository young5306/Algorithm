

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int w;
		
		Edge(){}
		Edge(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
	
		long total = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a, b, c));
			total += c;
		}
		
		// 크루스칼
		p = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		long answer = 0;
		int pick = 0;
		
		for(int i = 0; i < M; i++) {
			Edge edge = pq.poll();
			// 대표 비교
			int px = findSet(edge.x);
			int py = findSet(edge.y);
			if(px != py) {
				answer += edge.w;
				union(px, py);
				pick++;
//				System.out.println(Arrays.toString(p));
			}
			if(pick == (N - 1)) break;
		}
		
		System.out.println(pick != (N-1) ? -1 : total - answer);
	}
	
	static int findSet(int x) {
		if(p[x] == x) return x; // 아직 어디에도 연결안됨
		return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
	    p[y] = x;
	}
}
