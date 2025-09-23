
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		List<Integer>[] con = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			con[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			con[x].add(y);
			con[y].add(x);
		}
		
		// bfs
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, 0});
		boolean[] visited = new boolean[n + 1];
		int answer = 0;
		
		out: while(!q.isEmpty()) {
			int[] cur = q.poll();
			int v = cur[0];
			int depth = cur[1];
//			System.out.println(v+", "+depth);
			
			for(int nxt : con[v]) {
				if(visited[nxt]) continue;
				visited[nxt] = true;
				q.add(new int[] {nxt, depth + 1});
				
				if(nxt == b) {
//					System.out.println("ch");
					answer = depth + 1;
					break out;
				}
			}
		}
		
		System.out.println(answer == 0 ? -1 : answer);
		
	}

}
