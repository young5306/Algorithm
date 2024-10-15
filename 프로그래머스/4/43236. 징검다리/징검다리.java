import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
		int N = rocks.length;
		
		int left = 1;
		int right = distance;
		int answer = 0;

		while(left<=right) {
			int mid = (left+right)/2;
			// 확인
			int front = 0;
			int cnt = 1; // 출발점0
			for (int i = 0; i <= N; i++) {
				if(i==N) {
					if(distance >= front+mid) {
						cnt++;
					}
				}
				else if(rocks[i] >= front+mid) {
					front = rocks[i];
					cnt++;
				}
			}
			
			//
			if(cnt >= N+2-n) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
        return answer;
    }
}