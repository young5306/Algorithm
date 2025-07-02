import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int u;
		int v;
		int w;
		Edge(){}
		Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int[] p;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Edge[] edge = new Edge[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edge, new Comparator<Edge>(){
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.w - e2.w; // 오름차순 (작은순)
			}
		});
		
		// 준비
		p = new int[N+1]; 
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		int con = 0;
		int pick = 0;
		
		for(Edge e : edge) {
			int pu = findSet(e.u);
			int pv = findSet(e.v);
			
			if(pu != pv) { // 같은 트리로 이미 연결되어 있지 않으면 (사이클 방지)
				union(pu, pv);
				pick++;
				con += e.w;
				if(pick == N) break;
			}
		}
		
		System.out.println(con);
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
	
	static int findSet(int x) {
		if(p[x] == x) return x;
		return findSet(p[x]); //
	}
}
