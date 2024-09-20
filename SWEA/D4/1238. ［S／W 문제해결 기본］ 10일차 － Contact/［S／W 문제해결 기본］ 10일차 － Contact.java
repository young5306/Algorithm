import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adj = new ArrayList[101]; //1~100
			for (int i = 1; i <= 100; i++) {
				adj[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				adj[A].add(B); // 유향
			}
			
			boolean[] visited = new boolean[101];
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			visited[start] = true;
			PriorityQueue<Integer> pq = null;
			
			while(!q.isEmpty()) {
				
				pq = new PriorityQueue<>(Collections.reverseOrder());
				
				int qSize = q.size();
				for (int i = 0; i < qSize; i++) {
					int v = q.poll();
					pq.add(v);
					
					for(int vertex : adj[v]) {
						if(!visited[vertex]) {
							q.add(vertex);
							visited[vertex] = true;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+pq.poll());
		}

	}

}
