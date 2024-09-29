import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] result = new int[money.length];
			for (int i = 0; i < money.length; i++) {
				
				if(N/money[i] != 0) {
					result[i] = N/money[i];
					N%=money[i];
				}
			}
			
			System.out.println("#"+tc);
			for(int i : result) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
