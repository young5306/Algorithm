import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 최댓값을 최소로 (공유기 설치 반대)
		// 이분탐색 : mid 범위(0~최대구간길이)
		// 1) mid보다 큰구간 나왔을 때 
		// - 휴게소 세우기 (M--)
		// - front를 세운 위치로 갱신
		// 2) 끝나고 
		// - M>=0 이면 => (가능) mid값 저장 후, right 갱신
		// - M<0 이면  => left 갱신
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] restStop = new int[N+2]; // 0, L 포함
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			restStop[i] = Integer.parseInt(st.nextToken());
		}
		restStop[N+1] = L;
		Arrays.sort(restStop);
		// 입력 완료
		
//		System.out.println(Arrays.toString(restStop));
		
		int max = 0;
		int length = restStop.length;
		for (int i = 1; i < length; i++) {
			max = Math.max(max, restStop[i]-restStop[i-1]);
		}
//		System.out.println(max);
		
		// 이진탐색
		int left = 1;
		int right = max;
		int result = max;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			// 확인
			int cnt = M;
			int front = restStop[0];
			for (int i = 1; i < length ; i++) {
//				System.out.println(i+":"+(front)+","+mid+","+M+","+cnt);

				int distance = restStop[i] - front;
				if(distance>mid) {
					int minus = (distance-1)/mid;
					cnt -= minus;
				} 
				front = restStop[i];
			}
			
			
			if(cnt>=0) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
		
	}

}