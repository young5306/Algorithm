import java.util.Arrays;

class Solution {
    public int[] solution(int n, int m) {
        //int max = Math.max(n, m);
		//int min = Math.min(n, m);
		
		// 최대공약수
		int gcd = 1; 
		
		for(gcd = m; gcd>=1; gcd--) {
			if(m%gcd==0 && n%gcd==0) break;
		}
			
		// 최소공배수
		// 3 4 -> gcd 1 -> 3*4
		// 6 24 -> gcd 6 -> 24
		// 8 12 -> gcd 4 -> 24
		// (n/gcd) * (m/gcd) * gcd
		int lcm = (n/gcd) * (m/gcd) * gcd; 
		
        int[] answer = {gcd, lcm};
        return answer;
    }
}