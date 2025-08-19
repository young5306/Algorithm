
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 시간복잡도 10^6 * 10^5 -> 10^3 * 10^5

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] prefixSum = new int[N+ 1][N + 1]; // 행별로 누적합
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 1; j <= N ; j++) {
				sum += Integer.parseInt(st.nextToken());
				prefixSum[i][j] = sum;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int r = x1; r <= x2; r++) {
				sum += (prefixSum[r][y2] - prefixSum[r][y1 - 1]);
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
