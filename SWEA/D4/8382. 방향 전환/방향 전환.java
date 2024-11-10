

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			
			int rDis = Math.abs(r1-r2);
			int cDis = Math.abs(c1-c2);
			
			int sub = Math.abs(rDis-cDis);
			
			int ans = Math.min(rDis, cDis)*2;
			ans += (sub%2==0 ? sub*2 : sub*2-1);

			System.out.println("#" + tc + " " + ans);
		}
	}

}
// https://k-ang.tistory.com/60
// https://nodingco.tistory.com/m/66