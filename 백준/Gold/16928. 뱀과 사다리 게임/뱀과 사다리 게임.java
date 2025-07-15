
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 뱀사다리정보
		int[] info = new int[101];
		
		for(int i = 1; i < 101; i++) {
			info[i] = i;
		}
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			info[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		// bfs - 1번칸부터 시작
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int[] cnt = new int[101];
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i = 1; i <= 6; i++) {
				if(n + i > 100 || cnt[info[n + i]] != 0) {
					continue;
				}
				
				cnt[info[n + i]] = cnt[n] + 1;
				q.add(info[n + i]);
			}
		}
		
		System.out.println(cnt[100]);
	}
}
