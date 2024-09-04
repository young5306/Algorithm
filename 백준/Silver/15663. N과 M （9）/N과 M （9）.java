import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// N개 중 M개 (중복X, 순서O) -> 중복X 순열
		// 입력되는 수는 중복 -> 다른 숫자로 생각
		// 사전순 -> nums 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int[] sel = new int[M];
		boolean[] visited = new boolean[N];
		List<int[]> result = new ArrayList<>();
		combination(N, M, nums, visited, sel, result, 0);
		
		for (int[] arr : result) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		

	}
	
	public static void combination(int N, int M, int[] nums, boolean[] visited, int[] sel, List<int[]> result, int sidx) {
		// 기저 조건
		if(sidx == M) {
			// 똑같은 순열 있는지 확인해서 없으면 append 하는거
			int[] test = Arrays.copyOf(sel, M); // 새로운 배열을 만들어서 넣어야 함. 
			// 주소값 같은 배열로 계속 넣으면 결국 같은 배열만 여러개 든 리스트됨.
			for (int[] arr : result) {
				if(Arrays.equals(arr, test)) return; // arr.equals(test) 하면 안됨
			}
			result.add(test);
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[sidx] = nums[i];
				combination(N, M, nums, visited, sel, result, sidx+1);
				visited[i] = false;
			}
		}
	}

}

//String str1 = new String("one");
//String str2 = new String("one");
//String str3 = "two";
//String str4 = "two";
//System.out.println(str1==str2); // false - 주소가 다름
//System.out.println(str3==str4); // true - 문자열 풀에 있는 문자열 재사용해서 주소 같음
//System.out.println(str1.equals(str2)); // true - 값 비교
//
//int[] arr1 = {1,2,3};
//int[] arr2 = {1,2,3};
//System.out.println(arr1==arr2); // false - 주소 다름
//System.out.println(arr1.equals(arr2)); // false - Object.equals는 주소비교
//System.out.println(Arrays.equals(arr1, arr2)); //  true - 배열 값 비교

// (정리)
// String 
// == : 주소 비교
// equals : 값비교

// Object
// Object.equals : == 비교 (주소 비교)
// Arrays.equals(arr1, arr2) : 배열 값 비교
