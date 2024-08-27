class Solution {
	static int numbers[];
	static int sel[] = new int[3]; // 선택한 숫자 3개
	static int N;
	static int cnt;
	
	public static int solution(int[] nums) {
        
        // 완전 검색 - 조합(재귀)
        N = nums.length;
        numbers = new int[N];
        numbers = nums;
        cnt = 0;
       
        
        combination(0,0);

        return cnt;
    }
	
	public static void combination(int idx, int sidx) {
		
		// 기저 조건
		if(sidx==3) {
			int sum  = 0;
			// 소수인지 확인
			for (int i = 0; i < 3; i++) {
				sum += sel[i];
			}
			if(isPrime(sum)) {
				cnt++;
			}
			return;
		}
		if(idx>=N) {
			return;
		}
		
		
		// 재귀 부분
		// 선택
		sel[sidx] = numbers[idx];
		combination(idx+1, sidx+1);
		// 선택 X
		combination(idx+1, sidx);
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}