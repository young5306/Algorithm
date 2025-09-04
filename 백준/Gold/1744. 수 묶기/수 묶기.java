
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		
		// 양수, 음수 구분
		int idx = N;
		for(int i = 0; i < N; i++) {
			if(arr[i] <= 0) {
				idx = i;
				break;
			}
		}
		
		int sum = 0;
		// 양수
		for(int i = 0; i < idx - 1; i+=2) {
			if(N == 1) {
				sum += arr[i];
				break;
			}
			if(arr[i] * arr[i + 1] > arr[i] + arr[i + 1]) {
				sum += arr[i] * arr[i + 1];
			} else {
				sum += arr[i] + arr[i + 1];
			}
		}
		if((idx - 1) % 2 == 0) sum += arr[idx - 1];
//		System.out.println("양수 완: " + sum);
		
		// 음수
		for(int i = N - 1; i > idx; i-=2) {
			if(arr[i] * arr[i - 1] > arr[i] + arr[i - 1]) {
				sum += arr[i] * arr[i - 1];
			} else {
				sum += arr[i] + arr[i - 1];
			}
		}
		
		if((N - idx) % 2 != 0) sum += arr[idx];
//		System.out.println("음수 완: " + sum);
		
		System.out.println(sum);
	}
}
