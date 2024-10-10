import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// N (용액 개수 최대 10^5)
		// 조합으로 모두 확인하면 시간복잡도(N*(N-1)/2 = 약 2억) => 시간초과
		// 각 용액에 대해 이진탐색으로 특성값이 0에 가까워지는 용액 하나 고르기 시간복잡도 (NlogN = 약 50만log10)
		// 정렬 NlogN
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] solution = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solution);
		
		int iResult = 0; // 용액 하나 고정
		int minResult = Integer.MAX_VALUE; 
		int jResult = 1; // 특성값이 가장 작아지는 두번째 용액 이진 검색
		
		for (int i = 0; i <= N-2; i++) {

			int left = i+1;
			int right = solution.length-1;
			
			while(left<=right) {
				int mid = (left+right)/2;
				
				int value = solution[i] + solution[mid];
				// 더 작은 값 나오면 갱신
				if(minResult > Math.abs(value)) {
					minResult = Math.abs(value);
					iResult = i;
					jResult = mid;
				}
				
				if(value >=0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		System.out.println(solution[iResult]+" "+solution[jResult]);
		
	}

}
