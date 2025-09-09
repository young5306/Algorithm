
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	// 완탐: 10^9 -> 10초 시간초과
	// X + Y = K - Z; -> 10^6 + 10^6 * 1
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		
		Set<Integer> set = new HashSet<>();
		int idx = 0;
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				set.add(num[x] + num[y]);
			}
		}
	
		for(int k = N - 1; k >= 0; k--) {
			for(int z = k; z >= 0; z--) {
				int kz = num[k] - num[z];
				
				if(set.contains(kz)) {
					System.out.println(num[k]);
					return;
				}
			}
		}
	}

}
