
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 배열prim으로 
	
	static final int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws Exception {
		// mst
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 배열 프림
		boolean[] visited = new boolean[N];
		long[] minEdge = new long[N]; 
		// pq에 넣었을 때는 mst그룹->v중 가장 작은값이 먼저 나옴 (여기서는 min으로 갱신 직접 해줌)
		Arrays.fill(minEdge, INF);
		minEdge[0] = 0;
		
		long answer = 0;
		
		for(int i = 0; i < N; i++) { // 총 N개 정점 선택(mst에 편입)해야 함
			
			// 1) 미방문 정점 중 최소 edge 가지는 정점 구함 (pq 과정)
			int u = -1;
			long minVal = INF;
			for(int v = 0; v < N; v++) {
				if(!visited[v] && minEdge[v] < minVal) {
					minVal = minEdge[v];
					u = v;
				}
			}
			
			if(u == -1) break; // 연결 불가인 경우 (이 문제는 x)
			
			// 2) u를 mst에 포함
			visited[u] = true;
			answer += minEdge[u];
			
			// 3) u에 연결된 다른 점들의 minEdge를 갱신
			for(int v = 0; v < N; v++) {
				if(!visited[v] && cost[u][v] < minEdge[v]) {
					minEdge[v] = cost[u][v];
				}
			}
			
		}
		
		System.out.println(answer);
	}
}
