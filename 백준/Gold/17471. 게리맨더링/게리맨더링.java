
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	static boolean[] visited;
	static List<Integer>[] adj;
	static int[] popu;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1]; 
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		popu = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int node = Integer.parseInt(st.nextToken());
				adj[i].add(node);
			}
		}
		
		// 부분집합
		visited = new boolean[N+1];
		visited[1] = true; // 중복 방지 (A에 1포함)
		min = 1000;
		powerset(2);
		
		System.out.println( min==1000 ? -1 : min);

	} // main
	
	static void powerset(int idx) {
		// 기저 조건
		if(idx == N+1) {
			// 모두 A인 경우 제외
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) flag = false; 
			}
			if(flag) return;
				
		
			// 인접한지 확인
			boolean[] Bvisited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				Bvisited[i] = !visited[i];
			}
			if(isAdjacent(visited) && isAdjacent(Bvisited)) {
				// 인구 수 차이 구하기
				int sumA = 0;
				int sumB = 0;
				for (int i = 1; i <= N; i++) {
					if(visited[i]) sumA += popu[i];
					else sumB += popu[i];
				}
				min = Math.min(Math.abs(sumA-sumB), min);
//				System.out.println(Arrays.toString(visited));
//				System.out.println(sumA+"-"+sumB+"="+min);
			}
			return;
		}
		
		
		// 재귀 부분
		// A
		visited[idx] = true;
		powerset(idx+1);
		// B
		visited[idx] = false;
		powerset(idx+1);
		
	}
	
	static boolean isAdjacent(boolean[] visited) {
		List<Integer> A = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(visited[i]) A.add(i);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(A.get(0));
		int pick = 0;
		boolean[] checked = new boolean[N+1];
		while(!q.isEmpty()) {
			int region = q.poll();
			if(!A.contains(region) || checked[region]) continue;
			
			checked[region] = true;
			pick++;
			for (int i : adj[region]) {
				if(!checked[i]) q.add(i);
			}
		}
		
		if(pick == A.size()) return true;
		else return false;
		
	}
	
	

}
