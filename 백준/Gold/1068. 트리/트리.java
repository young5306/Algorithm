import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println("arr: " + Arrays.toString(arr));
		
		int X = Integer.parseInt(br.readLine());
		arr[X] = -10;
		dfs(X);
		
//		System.out.println("leaf removed: " + Arrays.toString(arr));
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			// 자식 없는 노드 구하기
			if(arr[i] == -10) continue;
			if(!existsChild(i)) {
				// System.out.println(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static void dfs(int x) {
		for(int i = 0; i < N; i++) {
			if(arr[i] == x) {
				arr[i] = -10;
				dfs(i);
			}
		}
	}
	
	static boolean existsChild(int n) {
		for(int i = 0; i < N; i++) {
			if(arr[i] == -10) continue;
			if(arr[i] == n) {
				return true;
			}
		}
		return false;
	}
}
