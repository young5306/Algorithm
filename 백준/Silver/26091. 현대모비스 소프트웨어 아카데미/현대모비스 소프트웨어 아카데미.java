import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ability = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ability[i] = Integer.parseInt(st.nextToken());
		}
		
//		if(N/2 == 0) {
//			System.out.println(0);
//			return;
//		}
		
		Arrays.sort(ability);
		int cnt = 0;
		int left = 0;
		int right = ability.length - 1;
		for (left = 0; left < ability.length; left++) {
			if(left >= right) break;
			if(ability[left] + ability[right] >= M) {
				cnt++;
				right--;
			}
		}
		
		System.out.println(cnt);
	}
}
