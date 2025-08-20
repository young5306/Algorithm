
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());

		long left = 1;
		long right = N * N;
		long result = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			// mid보다 작거나 같은 수의 개수가 k개 이상이어야 함
			long cnt = 0;
			for(long i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			if(cnt >= k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
//			System.out.println("mid: " + mid +", result: " + result);
		}
		
		System.out.println(result);
		
	} 

}
