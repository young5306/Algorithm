
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				// 유니온 파인드
				int pa = findSet(a);
				int pb = findSet(b);
				
				if(pa != pb) {
					union(pa, pb);
				}
			} else if(op == 1) {
				int pa = findSet(a);
				int pb = findSet(b);
				
				if(pa == pb) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.print(sb);
	}
	
	static int findSet(int a) {
		if(p[a] == a) return p[a];
		return p[a] = findSet(p[a]);
	}
	
	static void union(int a, int b) {
		p[a] = b;
	}

}
