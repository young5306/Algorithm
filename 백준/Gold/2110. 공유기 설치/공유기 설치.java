import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int left = 1;
		int right = (home[N-1]- home[0])/(C-1);
		int result = 0;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			int front = home[0];
			int cnt = 1;
			
			for (int i = 1; i < N; i++) {
				if(home[i] >= front + mid) {
					front = home[i];
					cnt++;
				}
			}
			
			if(cnt >= C) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			
		}

		System.out.println(result);
	}

}
