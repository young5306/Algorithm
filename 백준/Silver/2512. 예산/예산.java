import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] region = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			region[i] = Integer.parseInt(st.nextToken());
//			total += region[i];
			max = Math.max(max, region[i]);
		}
		int M = Integer.parseInt(br.readLine());

//		if(total <= M) System.out.println(max); // 굳이 필요 없을 듯
		// 상한선 이진탐색
		int left = 1;
		int right = max;
		int result = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			total = 0;

			for (int i = 0; i < N; i++) {
				if (region[i] > mid) {
					total += mid;
				} else {
					total += region[i];
				}
			}
			
			if (total <= M) { // 상한선 높여도 됨 
				result = mid;
				left = mid + 1;
			} else { // 상한선이 너무 높음
				right = mid - 1;
			}
		}
		
		System.out.println(result);

	}

}
