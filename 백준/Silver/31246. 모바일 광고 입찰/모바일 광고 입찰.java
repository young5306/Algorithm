

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 10^5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// moloco - top (-3, -2, -1, 0, 0, 1) -> 3개 입찰 가능
		// 만약 5개 입찰해야 하면 X = 2
		int[] subs = new int[N]; // moloco - top
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			subs[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
//			if (subs[i] >= 0) cnt++; // 확보 가능한 광고지면 수
		}
		Arrays.sort(subs); // 오름차순
		
		int X = 0;
		for(int i = N-1; i >= 0; i--) {
			if(subs[i] >= 0) {
				cnt++; 
				continue;
			}
			if(cnt >= K) break;
			cnt++;
			X = -subs[i];
		}
		
		System.out.println(X);
	}

}

// -20, 2, -2