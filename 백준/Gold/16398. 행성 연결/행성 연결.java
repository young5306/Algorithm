
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Planet implements Comparable<Planet> {
		int v;
		int w;
		Planet(){}
		Planet(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Planet o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		// mst
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Planet>[] planets = new LinkedList[N];
		for(int i = 0; i < N; i++) {
			planets[i] = new LinkedList<>();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				planets[i].add(new Planet(j, w));
			}
		}
		
		// mst (0부터 시작)
		PriorityQueue<Planet> pq = new PriorityQueue<>();
		pq.add(new Planet(0, 0));
		boolean[] visited = new boolean[N];
		int pick = 0;
		long answer = 0; // 10^11
		
		while(pick != N) {
			Planet cur = pq.poll();
			if(visited[cur.v]) continue;
			
			visited[cur.v] = true;
			pick++;
			answer += cur.w;
			
			for(Planet p : planets[cur.v]) {
				if(visited[p.v]) continue;
				pq.add(p);
			}
		}
		
		System.out.println(answer);
		
	}

}
