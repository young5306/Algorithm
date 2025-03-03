
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int visited = 0;
			
			int count = 1;
			for(count=1;; count++) {
				char[] charArr = String.valueOf(N*count).toCharArray();
				for(char ch : charArr) {
					int num = ch - '0';
					visited = visited | (1<<num);
				}
				
				if(visited == (1<<10) - 1) break;
			}
			
			System.out.println("#"+t+" "+N*count);
			
		}
	}
}
