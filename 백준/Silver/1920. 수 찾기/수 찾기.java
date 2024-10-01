
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] find = new int[M];
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		// 이진 검색하려면 nums 배열 정렬되어 있어야
		Arrays.sort(nums);
		
		for (int i = 0; i < M; i++) {
			// find[i]가 nums안에 있는지 확인 (이진 검색)
			
			int flag = binarySearch(find[i]);
			
			System.out.println(flag);
		}

	} // main
	
	static int binarySearch(int find) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(nums[mid] == find) return 1;
			else if (nums[mid] > find) right = mid-1;
			else if (nums[mid] < find) left = mid+1;
		}
		return 0;
	}

}

// 10만 * 10만 = 100 0000 0000 (100억) 100초 => 퀵정렬 최악의 경우 시간초과
// nlogn => 10만 * 5log2(10)
