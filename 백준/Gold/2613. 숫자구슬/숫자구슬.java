

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] bead;
	static int[] selected;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 구슬 수
		M = Integer.parseInt(st.nextToken()); // 경계값 = 그룹 수+1
		StringBuilder sb = new StringBuilder();

		bead = new int[N];
		int totalSum = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			bead[i] = num;
			totalSum += num;
			max = Math.max(max, num);
		}
		
		// 1. 최솟값 구하기 (이분탐색)
		int left = max; // 그룹에 하나라도 있어야 함.
		int right = totalSum;
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			// 확인 : 그룹 합이 mid보다 커지기 직전까지의 그룹들 개수를 구하고
			// cnt가 M보다 작거나 같은 경우만 result에 저장한다. -> 최솟값으로 갱신
			int cnt = 1;
			int sum = 0;
			for (int i = 0; i < N; i++) {

				if (sum + bead[i] > mid) { // 그룹합이 mid를 넘기면 다음 그룹으로 넘어감
					sum = 0;
					cnt++;
				}
				
				if(cnt>M) break;

				sum += bead[i];

			}

			if (cnt <= M) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		
		sb.append(result).append("\n");
		
		// 2. 그룹 개수 구하기

		int idx = 0;
		for (int i = 1; i <= M; i++) {
			
			int sum = 0;
			int cnt = 0;

			int j = 0;
			for (j = idx; j <= (N-1)-(M-i); j++) { // (N-1)-(남은그룹수)
				sum+=bead[j];
				cnt++;
				if(sum > result) {
					// 다음 그룹으로 넘어감
					// sum-=bead[j];
					cnt--;
					break;
				}
			}
			idx = j;
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);

	}

}

/*
10 8
14 5 5 4 2 2 2 2 2 4
*/
