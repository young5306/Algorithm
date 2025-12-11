class Solution {
    public int[] solution(int target) {
        
        // 1. 라운드 수 최소
        // 2. 싱글 + 불 수 최대
        // 3. 선공
        
        // dp[i][0]: 횟수
        // dp[i][1]: 싱글, 불 횟수
        int[][] dp = new int[target + 1][2];
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int t = 1; t <= target; t++) {
            
            // 불 맞춤
            if (t - 50 >= 0) {
                if(dp[t][0] > dp[t - 50][0] + 1) {
                    dp[t][0] = dp[t - 50][0] + 1;
                    dp[t][1] = dp[t - 50][1] + 1;
                } else if (dp[t][0] == dp[t - 50][0] + 1) {
                    dp[t][1] = Math.max(dp[t][1], dp[t - 50][1] + 1);
                }
            }
            
            for(int s = 1; s <= 20; s++) {
                // 싱글
                if(t - s >= 0) {
                    if(dp[t][0] > dp[t - s][0] + 1) {
                        dp[t][0] = dp[t - s][0] + 1;
                        dp[t][1] = dp[t - s][1] + 1;
                    } else if (dp[t][0] == dp[t - s][0] + 1) {
                        dp[t][1] = Math.max(dp[t][1], dp[t - s][1] + 1);
                    }
                }
            
                // 더블
                if(t - 2 * s >= 0) {
                    if(dp[t][0] > dp[t - 2 * s][0] + 1) {
                        dp[t][0] = dp[t - 2 * s][0] + 1;
                        dp[t][1] = dp[t - 2 * s][1];
                    } 
                }

                // 트리플
                if(t - 3 * s >= 0) {
                    if(dp[t][0] > dp[t - 3 * s][0] + 1) {
                        dp[t][0] = dp[t - 3 * s][0] + 1;
                        dp[t][1] = dp[t - 3 * s][1];
                    } 
                }
            }
        }

        return new int[] {dp[target][0], dp[target][1]};
    }
}