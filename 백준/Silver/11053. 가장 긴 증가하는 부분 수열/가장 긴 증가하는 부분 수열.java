import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		// 포인터
		// 1. 더 작은게 나오면 해당 자리 숫자에 갱신 (길이 그대로) -> 굳이 이진 탐색 안해도 됨. (N최대 1000)
		// 2. 큰게 나오면 추가 (길이+1됨)
		
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		
		for (int i = 1; i < N; i++) {
			int n = list.size();
			if(list.get(n-1) > arr[i]) {
				int j = n-1;
				for (j = n-1; j >= 0 ; j--) {
					if(list.get(j) < arr[i]) {
						break;
					}
					
				}
				list.set(j+1, arr[i]);
			} else if(list.get(n-1) < arr[i]) {
				list.add(arr[i]);
			}
		}
		//System.out.println(list);
		System.out.println(list.size());
	}

}
