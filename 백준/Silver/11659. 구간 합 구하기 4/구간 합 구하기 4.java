
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] prefixSum = new int[N + 1]; // 첫요소는 0으로
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			prefixSum[i] = sum;
		}
		
//		System.out.println(Arrays.toString(prefixSum));
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(prefixSum[b] - prefixSum[a - 1]).append("\n");
		}
		
		System.out.println(sb);
	}

} // 0 5 9 12 14 15

// all 반복문 돌면 10^10로 10초 걸림 (시간 초과)
