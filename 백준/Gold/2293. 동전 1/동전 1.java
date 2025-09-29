import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int[] dp = new int[K + 1];
		dp[0] = 1;
		
		for(int n = 0; n < N; n++) {
			for(int k = arr[n]; k <= K; k++) {
				dp[k] += dp[k - arr[n]];					
			}
//			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(dp[K]);
	}

}
