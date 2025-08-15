
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	// 프림보다는 크루스칼로 푸는게 적합해보임
	// 프림은 임의의 시작점에서 시작, 크루스칼은 최소비용 간선부터 시작
	// 크루스칼로 mst 구하다가 마지막 간선(최대비용간선)만 빼면 됨 -> 결국 마지막 점만 하나의 도시로 분리됨 

	static class Path {
		int x;
		int y;
		int w;
		
		Path(){}
		Path(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Path[] arr = new Path[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[i] = new Path(a, b, c);
		}
		
		Arrays.sort(arr, new Comparator<Path>() {
			@Override
			public int compare(Path p1, Path p2) {
				return p1.w - p2.w;
			}
		});
//		Arrays.sort(arr, (p1, p2) -> Integer.compare(p1.w, p2.w));
		
		// 크루스칼
		int answer = 0;
		int pick = 0; // 조기종료 (최적화)
		
		p = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		for(int i = 0; i < M; i++) {
			if(pick == N-2) break; // 마지막 점 빼고 종료

			Path path = arr[i];
			int px = findSet(path.x);
			int py = findSet(path.y);
			if(px != py) {
				answer += path.w;
				union(px, py);
				pick++;
			}
		}
		
		System.out.println(answer);
	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int rx, int ry) {
		p[rx] = ry;
	}

}
