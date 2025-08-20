
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N];
		int idx = 0;
		cnt[0] = 1;
		out: while(true) {
			for(int i = 0; i < N; i++) {
				if(cnt[i] >= M) break out;
			}
			
			if(cnt[idx] % 2 == 0) {
				idx = (idx - L + N) % N;
				cnt[idx]++;
			} else {
				idx = (idx + L) % N;
				cnt[idx]++;
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += cnt[i];
		}
		
		System.out.println(ans - 1);

	}

}
