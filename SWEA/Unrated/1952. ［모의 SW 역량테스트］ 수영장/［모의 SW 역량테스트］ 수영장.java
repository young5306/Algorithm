import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int mon = Integer.parseInt(st.nextToken());
			int threeMon = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			int[] plan = new int[13]; // 0~12
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			} // 입력 완료

			int[] dp = new int[13];

			for (int j = 1; j <= 12; j++) { // 임시 월
				if(plan[j]!=0) { 
					
					// 1일권 사용하는 경우
					int minCnt = Math.min(987654321, dp[j-1] + plan[j]*day);
					// 1일, 1달권 사용하는 경우 
					minCnt = Math.min(minCnt, dp[j-1]+mon);
//					int minCnt = dp[j-1] + Math.min(plan[j]*day, mon); // 1일, 1달권 합쳐서 코드 작성 가능
					
					// 1일, 1달, 3달권 사용하는 경우
					if(j>=3) minCnt = Math.min(minCnt, dp[j-3]+threeMon);
					else minCnt = Math.min(minCnt, threeMon);
					
					// 1일, 1달, 3달권, 1년권 사용하는 경우
					if(j>=12) minCnt = Math.min(minCnt, dp[j-12]+year);
					else minCnt = Math.min(minCnt, year);
					
					dp[j] = minCnt;
				} else {
					dp[j] = dp[j-1];
				}
				
			}
//			System.out.println(Arrays.toString(dp));
			
			System.out.println("#"+tc+" "+dp[12]);
		}

	}

}
