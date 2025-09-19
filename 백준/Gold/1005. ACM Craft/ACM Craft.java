
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adj;
	static int[] time;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			adj = new LinkedList[N + 1];
			for(int i = 1; i <= N; i++) {
				adj[i] = new LinkedList<>();
			}
			int[] indeg = new int[N + 1]; 
			for(int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				indeg[b]++;
			}
			
			// 위상 정렬
			int W = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				if(indeg[i] == 0) {
					dp[i] = time[i];
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int nx : adj[cur]) {
					dp[nx] = Math.max(dp[nx], dp[cur] + time[nx]);
					if(--indeg[nx] == 0) q.add(nx);
				}
			}
			
			System.out.println(dp[W]);
		} // t

	}
}
