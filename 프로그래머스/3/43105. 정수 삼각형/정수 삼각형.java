class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(i == 0 && j == 0) continue;
                if(j == 0) dp[i][j] = dp[i-1][j];
                else if(j == triangle[i].length - 1) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
                dp[i][j] += triangle[i][j];
            }
        }
        
        int answer = 0;
        
        for(int n : dp[triangle.length-1]) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}