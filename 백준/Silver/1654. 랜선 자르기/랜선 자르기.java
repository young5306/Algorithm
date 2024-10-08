

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lan = new int[K];
		int max = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
		// 1 ~ 가장 긴 길이 => 범위에서 이진탐색

		long left = 1;
		long right = max;
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long total = 0;

			for (int i = 0; i < K; i++) {
				total += (lan[i] / mid);
			}
			if (total >= N) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);

	}

}
