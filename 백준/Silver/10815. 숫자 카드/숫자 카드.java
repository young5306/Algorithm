
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] Ns = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Ns);
		int M = Integer.parseInt(br.readLine());
		int[] Ms = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Ms[i] = Integer.parseInt(st.nextToken());
		}
		// 범위 -10^7~10^7
		// 완탐 10^14 (2초 2*10^9 넘음)
		// => Arrays.sort : nlogn
		// => 이진탐색 : logn
		
		for (int j = 0; j < M; j++) {
			int key = Ms[j];
			sb.append(binarySearch(Ns, key)).append(" ");
		}
		System.out.println(sb);
		
	}
	
	static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid] == key) return 1;
			else if(arr[mid] < key) left = mid+1; 
			else if(arr[mid] > key) right = mid-1; 
		}
		return 0;
	}

}
