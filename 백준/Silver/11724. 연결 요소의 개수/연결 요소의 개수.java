

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception { // DFS, BFS, 유니온 파인드 가능
		
		// 치즈도둑, 유기농 배추와 유사
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// dfs
		visited = new boolean[N+1];
		cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	
	static void dfs(int v) {
		visited[v] = true;
		for (int i = 0; i < adj[v].size(); i++) {
			int n = adj[v].get(i);
			if(!visited[n]) {
				dfs(n);
			}
		}
	}

}

// 인접행렬의 장점 : 같은 간선은 한번만 주어진다. (중복 간선 들어와도 처리가 쉽다(할게 X))
// [1][[2,2,3,4]] -> 리스트는 입력은 그대로 중복으로 들어옴. dfs 돌면서 visited로 중복처리하게 됨. (불필요한 확인하게 됨)