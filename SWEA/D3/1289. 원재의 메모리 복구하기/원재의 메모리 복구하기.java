import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			
			int cnt = 0;
			// 초기값 00..
			char prev = '0';
			for (int i = 0; i < str.length(); i++) {
				char bit = str.charAt(i);
				
				if(prev != bit) {
					cnt++;
					prev = bit;
				}
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}

	}

}
