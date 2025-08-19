
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] prefixSum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int ans = Integer.MAX_VALUE;
		for(int r = 1; r <= N; r++) {
			// left + 1, r 구간합 = prefixSum[r] - prefixSum[left]
			while(left < r && prefixSum[r] - prefixSum[left] >= S) {
				ans = Math.min(ans, r - left);
				left++;
			}
		}

		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}

}
