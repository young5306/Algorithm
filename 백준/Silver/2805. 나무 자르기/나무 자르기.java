import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		// 입력 완료

//		int result = binarySearch(tree, 0, max);
		int result = binarySearch(tree);
		System.out.println(result);

	}

	static int recurBinarySearch(int[] tree, int left, int right) {
		// 기저조건
		int mid = (left + right) / 2;

		if (left > right) return mid;

		int total = 0;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] > mid)
				total += (tree[i] - mid);
		}

		if (total >= M) return recurBinarySearch(tree, mid + 1, right);
		else return recurBinarySearch(tree, left, mid - 1);
	}
	
	static int binarySearch(int[] tree) {
		int left = 0;
		int right = max;
		int mid = 0;
		
		while(left <= right) {
			
			mid = (left+right)/2;
			//System.out.println(mid);

			long total = 0;
			for (int i = 0; i < tree.length; i++) {
				if(tree[i] > mid) {
					total += (tree[i]-mid);
				}
			}
			
			if(total == M) return mid;
			// 더 자름
			if(total > M) left = mid+1;
			// 덜 자름
			else if(total < M) right = mid - 1;
		}
		
		return right;
		
	}
}

/*
4 7
20 16 10 17
-> 답 15
 */
