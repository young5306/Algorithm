

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 심사대 수
		int M = Integer.parseInt(st.nextToken()); // 인원 수
		// -> 상근이 친구 최대 10억명 0o0
		// 범위 너무 큼. 이진탐색 고려
		
		int[] checkpoint = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max, num);
			checkpoint[i] = num;
		}
		Arrays.sort(checkpoint); // 오름차순

		long left = 1;
		long right = M*(long)max;
		long result = 0;
		
		while(left<=right) {
			long mid = left + (right-left)/2;
			
			// 시간 안에 심사 가능한지 확인
			long pp = 0;
			for (int i = 0; i < N; i++) {
				pp += mid/checkpoint[i];
				if(pp >= M) break;
			}
			
			if(pp>=M) { 
				result = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		
		System.out.println(result);
	}
}
