
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
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		
		int answer = Integer.MAX_VALUE;
		while(left <= right && right < N) {
			
			int subs = arr[right] - arr[left];
			
			if(subs < M) {
				right++;
			} else if(subs > M) {
				left++;
				answer = Math.min(answer, subs);
			} else {
				answer = M;
				break;
			}
			
		}
		
		System.out.println(answer);
	}

}
